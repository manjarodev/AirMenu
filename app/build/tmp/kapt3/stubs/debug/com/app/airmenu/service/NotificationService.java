package com.app.airmenu.service;

import java.lang.System;

/**
 * This is the main service which will run in backgournd
 * always and monitor all incoming orders from UberEats and forward them
 * to AirMenu. Also this service is responsible to establish and
 * maintain the connection with AirMenu socket and monitor orders status
 * changed by AirMenu and update Uber accordingly.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u0002:\u0002\u009c\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J2\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0002J \u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002J:\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002J\u001a\u0010@\u001a\u00020.2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0002J \u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020C2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0005H\u0002J&\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u0010J\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010K\u001a\u0002052\u0006\u00100\u001a\u000201J\u000e\u0010L\u001a\u0002052\u0006\u00100\u001a\u000201J\u0018\u0010M\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u00100\u001a\u000201H\u0002J\u0016\u0010N\u001a\u00020\u00052\f\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PH\u0002J$\u0010R\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u000203H\u0002J\b\u0010S\u001a\u00020.H\u0002J\b\u0010T\u001a\u000205H\u0002J\b\u0010U\u001a\u00020.H\u0002J\u0010\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020XH\u0002J:\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u00020\u00052\u0006\u00104\u001a\u0002052\u0006\u00100\u001a\u0002012\u0006\u0010/\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u0005H\u0002J\u0010\u0010[\u001a\u0002052\u0006\u0010\\\u001a\u00020\u0005H\u0002J(\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u0005J\u0016\u0010_\u001a\u00020\u00052\f\u0010`\u001a\b\u0012\u0004\u0012\u00020a0PH\u0002J\u0016\u0010b\u001a\u00020\u00052\f\u0010`\u001a\b\u0012\u0004\u0012\u00020a0PH\u0002J \u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020C2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0018\u0010e\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J2\u0010f\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0002J\u0012\u0010g\u001a\u00020.2\b\u0010Z\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010h\u001a\u00020.2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0018\u0010i\u001a\u0004\u0018\u00010\u00052\f\u0010O\u001a\b\u0012\u0004\u0012\u00020a0PH\u0002J\u0010\u0010j\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0002J\u0018\u0010j\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u0010k\u001a\u00020\u0014H\u0002J\u0010\u0010l\u001a\u00020.2\u0006\u0010m\u001a\u00020\u0005H\u0002J\b\u0010n\u001a\u00020.H\u0016J\b\u0010o\u001a\u00020.H\u0016J\"\u0010p\u001a\u00020*2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020*2\u0006\u0010t\u001a\u00020*H\u0016J\u0012\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u000205H\u0002J\u0012\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010w\u001a\u000205H\u0002J\u0012\u0010z\u001a\u0004\u0018\u00010C2\u0006\u0010w\u001a\u00020\u0005H\u0002J\u0016\u0010{\u001a\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010w\u001a\u00020\u0005H\u0002J\u0012\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010w\u001a\u00020\u0005H\u0002J\u0014\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0006\u0010w\u001a\u00020\u0005H\u0002J3\u0010\u0082\u0001\u001a\u00020.2\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u0005H\u0002J3\u0010\u0083\u0001\u001a\u00020.2\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u0005H\u0002J\u001b\u0010\u0084\u0001\u001a\u00020.2\u0007\u0010\u0085\u0001\u001a\u00020\u00142\u0007\u0010\u0086\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020.2\u0007\u0010\u0085\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0088\u0001\u001a\u00020.H\u0002J\u001d\u0010\u0089\u0001\u001a\u00020.2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u008c\u0001\u001a\u00020.2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010m\u001a\u00020\u0005J0\u0010\u008d\u0001\u001a\u00020.2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010q\u001a\u0004\u0018\u00010rJ\t\u0010\u0090\u0001\u001a\u00020.H\u0003J\u0013\u0010\u0091\u0001\u001a\u00020.2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\u0092\u0001\u001a\u00020.2\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0093\u0001\u001a\u00020\u00052\u0007\u0010\u0094\u0001\u001a\u00020\u0005H\u0002J\u0013\u0010\u0095\u0001\u001a\u00020.2\b\u0010Z\u001a\u0004\u0018\u00010\u0005H\u0002J/\u0010\u0096\u0001\u001a\u00020.2\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0093\u0001\u001a\u00020\u00052\u0007\u0010\u0094\u0001\u001a\u00020\u00052\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0098\u0001\u001a\u00020.2\u0007\u0010\u0086\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020.2\u0007\u0010\u009a\u0001\u001a\u00020*H\u0002J3\u0010\u009b\u0001\u001a\u00020.2\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009d\u0001"}, d2 = {"Lcom/app/airmenu/service/NotificationService;", "Landroidx/lifecycle/LifecycleService;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "ORDER_SOCKET_MESSAGE", "", "PING_MESSAGE", "PONG_MESSAGE", "SUCCESS_SOCKET_MESSAGE", "bufIn", "Ljava/io/BufferedReader;", "bufOut", "Ljava/io/BufferedWriter;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "helper", "Lcom/app/airmenu/room/database/DatabaseHelperImpl;", "isSocketConnected", "", "job", "Lkotlinx/coroutines/Job;", "mMessageReceiver", "Landroid/content/BroadcastReceiver;", "mObserver", "Landroidx/lifecycle/Observer;", "placesClient", "Lcom/google/android/libraries/places/api/net/PlacesClient;", "prefRepository", "Lcom/app/airmenu/local/PreferenceRepository;", "getPrefRepository", "()Lcom/app/airmenu/local/PreferenceRepository;", "setPrefRepository", "(Lcom/app/airmenu/local/PreferenceRepository;)V", "remoteRepository", "Lcom/app/airmenu/remote/RemoteRepository;", "getRemoteRepository", "()Lcom/app/airmenu/remote/RemoteRepository;", "setRemoteRepository", "(Lcom/app/airmenu/remote/RemoteRepository;)V", "retryCount", "", "sessionManager", "Lcom/app/airmenu/session/SessionManager;", "createMenuAtAirMenu", "", "divisionId", "body", "Lcom/app/airmenu/network/response/OrderDetail;", "result", "Lcom/app/airmenu/models/GoogleAddress$Result;", "orderjson", "Lorg/json/JSONObject;", "username", "createSocketForMessages", "host", "port", "authToken", "createUserJson", "firstName", "lastName", "phone", "phoneCode", "createUserWithChoosenLDE", "createUserWithCustomLDE", "mainResponse", "Lcom/app/airmenu/models/LocationDivisionEnterpriseResponse;", "formatToJsonAuth", "email", "password", "formatToJsonNotification", "sessionId", "enterpriseId", "posId", "getCreateMenuJson", "getCreateMissingMenuJson", "getDivisionIdByUserAddress", "getLastFlag", "activeFlags", "", "Lcom/app/airmenu/models/ActiveFlag;", "getLocationDivisionJson", "getNewOrderFromAirMenu", "getNewOrderJson", "getNotificationCredentials", "getOrderDetails", "notificationMessage", "Lcom/app/airmenu/models/NotificationMessage;", "getOrderDetailsForFutureOrder", "orderId", "getOrderUpdateAirMenuJson", "orderInfo", "getOrderjson", "id", "getReasonForCancel", "extraInfo", "Ljava/lang/Object;", "getReasonForDeny", "getSessionIdForCustomLDE", "mainResponse1", "getSessionIdForLDE", "getSessionIdForSaveMenu", "getSessionIdForUpdateFlag", "getSessionIdForUser", "getUberOrderId", "handleOrderResponse", "b", "handleSocketMessage", "messageStr", "onCreate", "onDestroy", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "parseCancelResponse", "Lcom/app/airmenu/service/ExtraInfoCancel;", "json", "parseDenyResponse", "Lcom/app/airmenu/service/ExtraInfo2;", "parseLDEResponse", "parseOrders", "", "Lcom/app/airmenu/models/AirMenuOrders$Orders$OrdDtl;", "parseToJsonObjLogin", "Lcom/app/airmenu/models/LoginResponse;", "parseToJsonObjNotification", "Lcom/app/airmenu/models/NotificationAccessResponse;", "placeAlertOrder", "placeOrderAtAirMenu", "sendMessageToActivity", "msg", "status", "sessionOut", "shouldConnectSocketAgain", "showErrorNotification", "title", "message", "showMessage", "showNotification1", "context", "Landroid/content/Context;", "startMyOwnForeground", "startPingCycle", "updateDeliveryStatus", "uberOrderId", "airmenuOrderId", "updateOrderStatusAtAirMenu", "updateOrderStatusAtUber", "reason", "updatePOSStatus", "updateSessionId", "api", "updateSessionIdForNewOrder", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NotificationService extends androidx.lifecycle.LifecycleService implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.airmenu.service.NotificationService.Companion Companion = null;
    private static java.net.Socket socket;
    private static boolean mFlag = false;
    private static boolean isServiceRunning = false;
    private int retryCount = 0;
    private final java.lang.String SUCCESS_SOCKET_MESSAGE = "SUCCESS";
    private final java.lang.String PING_MESSAGE = "ping";
    private final java.lang.String PONG_MESSAGE = "pong";
    private final java.lang.String ORDER_SOCKET_MESSAGE = "ApiAction_GetOrders";
    private kotlinx.coroutines.Job job;
    private java.io.BufferedWriter bufOut;
    private java.io.BufferedReader bufIn;
    private boolean isSocketConnected = false;
    private com.app.airmenu.session.SessionManager sessionManager;
    private com.google.android.libraries.places.api.net.PlacesClient placesClient;
    private com.app.airmenu.room.database.DatabaseHelperImpl helper;
    @javax.inject.Inject()
    public com.app.airmenu.local.PreferenceRepository prefRepository;
    @javax.inject.Inject()
    public com.app.airmenu.remote.RemoteRepository remoteRepository;
    private androidx.lifecycle.Observer<java.lang.Boolean> mObserver;
    private final android.content.BroadcastReceiver mMessageReceiver = null;
    
    public NotificationService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.local.PreferenceRepository getPrefRepository() {
        return null;
    }
    
    public final void setPrefRepository(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.local.PreferenceRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.remote.RemoteRepository getRemoteRepository() {
        return null;
    }
    
    public final void setRemoteRepository(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.remote.RemoteRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    /**
     * This method is responsible to establish the socket connection
     * @param host
     * @param port
     * @param authToken
     */
    @kotlin.Suppress(names = {"DEPRECATED_IDENTITY_EQUALS"})
    private final void createSocketForMessages(java.lang.String host, java.lang.String port, java.lang.String authToken) {
    }
    
    /**
     * This method is reponsible to update AirMenu sessionId
     * for All other APIs at runtime (during order placement)
     * @param api
     */
    private final void updateSessionId(int api) {
    }
    
    /**
     * This method will get and update the socket credentials
     * such as accessToken for socket connection and upate them
     * in local data structure (sharedPrefrences)
     */
    private final void getNotificationCredentials() {
    }
    
    /**
     * This method will be used when socket will disconnected
     * And it will make sure that after socket disconnected
     * buffer and socket should be null before initializing them
     * again. Also it will initiate new socket connection request
     * if the network will be available.
     */
    private final void shouldConnectSocketAgain() {
    }
    
    /**
     * This method will be fired each time socket will
     * receive any message and take action if the message
     * will be of order message.
     */
    private final void handleSocketMessage(java.lang.String messageStr) {
    }
    
    /**
     * This method is responsible to get new orders from
     * AirMenu right after socket will get message form AirMenu
     * Also it will check the order status and call Order status
     * APIs accordingly.
     */
    private final void getNewOrderFromAirMenu() {
    }
    
    /**
     * This method will get the uber order id from active flags
     * get from AirMenu Order information.
     * @param activeFlags
     * @return response as String
     */
    private final java.lang.String getUberOrderId(java.util.List<? extends java.lang.Object> activeFlags) {
        return null;
    }
    
    /**
     * This method will update Order Delivery status at Uber
     * Also it will call showNotification to update user through
     * notification.
     * @param status
     * @param uberOrderId
     * @param airmenuOrderId
     */
    private final void updateDeliveryStatus(java.lang.String status, java.lang.String uberOrderId, java.lang.String airmenuOrderId) {
    }
    
    /**
     * This method will show notification to user on order status upate from AirMenu.
     * @param context
     * @param title
     * @param body (body of the message)
     * @param intent
     */
    public final void showNotification1(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String body, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    /**
     * This method will show notification on error.
     * @param context
     * @param title
     * @param body (body of the message)
     * @param intent
     */
    public final void showErrorNotification(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    /**
     * This method will extract the order deny/ cancel reason
     */
    private final java.lang.String getReasonForCancel(java.util.List<? extends java.lang.Object> extraInfo) {
        return null;
    }
    
    private final java.lang.String getReasonForDeny(java.util.List<? extends java.lang.Object> extraInfo) {
        return null;
    }
    
    private final java.lang.String getLastFlag(java.util.List<com.app.airmenu.models.ActiveFlag> activeFlags) {
        return null;
    }
    
    private final void updateOrderStatusAtUber(java.lang.String status, java.lang.String uberOrderId, java.lang.String airmenuOrderId, java.lang.String reason) {
    }
    
    private final void getSessionIdForUpdateFlag(java.lang.String orderId) {
    }
    
    private final void getSessionIdForUser(com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result) {
    }
    
    private final com.app.airmenu.models.LoginResponse parseToJsonObjLogin(java.lang.String json) {
        return null;
    }
    
    private final com.app.airmenu.service.ExtraInfo2 parseDenyResponse(org.json.JSONObject json) {
        return null;
    }
    
    private final com.app.airmenu.service.ExtraInfoCancel parseCancelResponse(org.json.JSONObject json) {
        return null;
    }
    
    private final java.lang.String formatToJsonAuth(java.lang.String email, java.lang.String password) {
        return null;
    }
    
    private final org.json.JSONObject getNewOrderJson() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void updateOrderStatusAtAirMenu(java.lang.String orderId) {
    }
    
    private final org.json.JSONObject getOrderUpdateAirMenuJson(java.lang.String orderInfo) {
        return null;
    }
    
    private final void getOrderDetails(com.app.airmenu.models.NotificationMessage notificationMessage) {
    }
    
    private final void handleOrderResponse(com.app.airmenu.network.response.OrderDetail body, boolean b) {
    }
    
    private final void getOrderDetailsForFutureOrder(java.lang.String orderId, org.json.JSONObject orderjson, com.app.airmenu.network.response.OrderDetail body, java.lang.String divisionId, com.app.airmenu.models.GoogleAddress.Result result, java.lang.String username) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void startMyOwnForeground() {
    }
    
    private final void startPingCycle(java.io.BufferedWriter bufOut) {
    }
    
    private final void handleOrderResponse(com.app.airmenu.network.response.OrderDetail body) {
    }
    
    private final void createUserWithChoosenLDE(com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result) {
    }
    
    private final void getDivisionIdByUserAddress(com.app.airmenu.models.GoogleAddress.Result result, com.app.airmenu.network.response.OrderDetail body) {
    }
    
    private final void getSessionIdForLDE(com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result) {
    }
    
    private final void createUserWithCustomLDE(com.app.airmenu.models.LocationDivisionEnterpriseResponse mainResponse, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result) {
    }
    
    private final void getSessionIdForCustomLDE(com.app.airmenu.models.LocationDivisionEnterpriseResponse mainResponse1, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result) {
    }
    
    private final void placeOrderAtAirMenu(org.json.JSONObject orderjson, java.lang.String divisionId, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result, java.lang.String username) {
    }
    
    private final void placeAlertOrder(org.json.JSONObject orderjson, java.lang.String divisionId, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result, java.lang.String username) {
    }
    
    private final void updateSessionIdForNewOrder(org.json.JSONObject orderjson, java.lang.String divisionId, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result, java.lang.String username) {
    }
    
    private final void createMenuAtAirMenu(java.lang.String divisionId, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result, org.json.JSONObject orderjson, java.lang.String username) {
    }
    
    private final void getSessionIdForSaveMenu(java.lang.String divisionId, com.app.airmenu.network.response.OrderDetail body, com.app.airmenu.models.GoogleAddress.Result result, org.json.JSONObject orderjson, java.lang.String username) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.json.JSONObject getCreateMenuJson(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.network.response.OrderDetail body) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.json.JSONObject getCreateMissingMenuJson(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.network.response.OrderDetail body) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.json.JSONObject getOrderjson(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.network.response.OrderDetail body, @org.jetbrains.annotations.Nullable()
    com.app.airmenu.models.GoogleAddress.Result result, @org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return null;
    }
    
    private final org.json.JSONObject createUserJson(java.lang.String firstName, java.lang.String lastName, com.app.airmenu.models.GoogleAddress.Result result, java.lang.String phone, java.lang.String phoneCode, java.lang.String username) {
        return null;
    }
    
    private final com.app.airmenu.models.LocationDivisionEnterpriseResponse parseLDEResponse(java.lang.String json) {
        return null;
    }
    
    private final java.util.List<com.app.airmenu.models.AirMenuOrders.Orders.OrdDtl> parseOrders(java.lang.String json) {
        return null;
    }
    
    private final java.lang.String getLocationDivisionJson(java.lang.String sessionId, java.lang.String enterpriseId, com.app.airmenu.models.GoogleAddress.Result result) {
        return null;
    }
    
    private final com.app.airmenu.models.NotificationAccessResponse parseToJsonObjNotification(java.lang.String json) {
        return null;
    }
    
    private final java.lang.String formatToJsonNotification(java.lang.String sessionId, java.lang.String enterpriseId, java.lang.String posId) {
        return null;
    }
    
    public final void showMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String messageStr) {
    }
    
    private final void updatePOSStatus(boolean status) {
    }
    
    private final void sendMessageToActivity(boolean msg, boolean status) {
    }
    
    private final void sessionOut(java.lang.String msg) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/app/airmenu/service/NotificationService$Companion;", "", "()V", "isServiceRunning", "", "()Z", "setServiceRunning", "(Z)V", "mFlag", "socket", "Ljava/net/Socket;", "isSocketConnected", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isServiceRunning() {
            return false;
        }
        
        public final void setServiceRunning(boolean p0) {
        }
        
        public final boolean isSocketConnected() {
            return false;
        }
    }
}