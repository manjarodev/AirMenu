package com.app.airmenu.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.app.airmenu.local.PreferenceRepository;
import com.app.airmenu.remote.RemoteRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class JavaNotificationService extends Service {

    private final static String TAG = JavaNotificationService.class.getSimpleName();
    private final static String SUCCESS_SOCKET_MESSAGE = "SUCCESS";
    private final static String PING_MESSAGE = "ping";
    private final static String PONG_MESSAGE = "pong";
    private final static String ORDER_SOCKET_MESSAGE = "ApiAction_GetOrders";
    private final static int HANDSHAKE_FAIL_ERROR_CODE = 304;
    private final static int PING_PERIOD = 600000;
    private final static String SCRIPT_SOCKET_MESSAGE = "ApiAction_GetPosScripts";
    private Timer pingTimer;
    private Socket socket;
    private Boolean keepRunning = true;

    @Inject
    public RemoteRepository remoteRepository;

    @Inject
    public PreferenceRepository preferenceRepository;

    public interface ActionCompleteCommand {
        void onSuccess();

        void onError(String message, int statuCode);
    }


    private ActionCompleteCommand mCallback;

    private void setActionCompleteCommand(ActionCompleteCommand actionCompleteCommand) {
        this.mCallback = actionCompleteCommand;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    createSocketForMessages("3.8.238.193", preferenceRepository.getNotificationResponse().getPort(), preferenceRepository.getNotificationResponse().getToken());

                } catch (Exception e) {
                    Log.e(TAG, "run:  exception while creating socket" + e.getMessage());
                }

            }
        }.start();


        return START_STICKY;


    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startMyOwnForeground();
        } else {
            //todo start something else...
        }

    }


    private void createSocketForMessages(String host, String port, String token) {

        System.out.println(host);
        System.out.println(port);
        System.out.println(token);

        BufferedWriter bufOut = null;
        BufferedReader bufIn = null;
        try {
            socket = new Socket(host, Integer.parseInt(port));
            bufOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            bufOut.write(token);
            bufOut.newLine();
            bufOut.flush();

            StringBuilder handShakeResponce = new StringBuilder();
            char[] buf = new char[1];


            do {
                //noinspection ResultOfMethodCallIgnored
                bufIn.read(buf);
                handShakeResponce.append(buf[0]);
                Log.e(TAG, "response form server => "+handShakeResponce );
            }while(handShakeResponce.length() < SUCCESS_SOCKET_MESSAGE.length());


            System.out.println(handShakeResponce.toString());

            if (!handShakeResponce.toString().equals(SUCCESS_SOCKET_MESSAGE)) {
                Log.e(TAG, "socket status disconnected");
                // if(actionCompleteCommand != null) actionCompleteCommand.onError("Socket handshake failure.", HANDSHAKE_FAIL_ERROR_CODE);

                return;
            } else {
                Log.e(TAG, "socket connected");

                startPingCycle(bufOut);

                StringBuilder message = new StringBuilder();
                //noinspection InfiniteLoopStatement
                try {
                    do {
                        bufIn.read(buf);
                        if (buf[0] == '\0') {
                            String messageStr = message.toString();
                            handleSocketMessage(messageStr);
                            message.setLength(0);
                        } else {
                            message.append(buf[0]);
                        }
                        if (message.toString().equals(PONG_MESSAGE)) {
                            String messageStr = message.toString();
                            handleSocketMessage(messageStr);
                            message.setLength(0);
                        }
                    } while (true);
                } catch (Exception e) {
                    Log.e(TAG, "excptn => " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "createSocketForMessages: IOExc" + e.getMessage());
        } finally {
            if (bufOut != null) {
                try {
                    bufOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufIn != null) {
                try {
                    bufIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleSocketMessage(String messageStr) {
        Log.e(TAG, "handleSocketMessage: called " + messageStr + "\n");
    }


    private void startPingCycle(final BufferedWriter bufOut) {
        pingTimer = new Timer();
        pingTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    bufOut.write(PING_MESSAGE);
                    bufOut.newLine();
                    bufOut.flush();
                } catch (IOException e) {
                    try {
                        if (pingTimer != null)
                            pingTimer.cancel();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    e.printStackTrace();
                    try {
                        if (socket != null)
                            socket.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }, PING_PERIOD, PING_PERIOD);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private void startMyOwnForeground() {
        String NOTIFICATION_CHANNEL_ID = "com.airmenu.javaservice";
        String channelName = "Socket service start";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(false)
                .setContentTitle("Socket service start")
                .setAutoCancel(true)
                .setPriority(NotificationManager.IMPORTANCE_LOW)
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        startForeground(2, notification);
    }

}
