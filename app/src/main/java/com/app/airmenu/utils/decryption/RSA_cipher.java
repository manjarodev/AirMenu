package com.app.airmenu.utils.decryption;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.app.airmenu.BuildConfig;
import com.app.airmenu.R;
import com.app.airmenu.utils.ConstantsKt;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RSA_cipher {

    public static final String TAG = RSA_cipher.class.getSimpleName();

    public static String SymmetricKey = "EzcWrnDkY6UmjbYrHxVlLzkgif6LEHDY9Fnxeg0nZGBUhS7hmBpoIhWFKG5Acvtt3EefH4QrchHjmMT4hOBPoiCMiCRIEu6ORVidv1w/CieKozhCsurHw9DAMVmJhJbArVNgXWJnO+J2IsuceVlB337XsK8G37raelU0DVD45KA+ob2Lym2dV0xMX2n7mKYMEFaTHwoYyR+TByeeZorA3cncQkXQuQN6PRS3kpdiEM2VUzzkzVQ5dH1qBpHsCsah/Zv78lyvKd1VowwXZC3E9+PJ3I4thq9lsSsFmIWcBtve927Lf2naWWA/gIHt3cY13trR3KYuq6CPBZsN06gh8w\\u003d\\u003d";
    public static String CipherText = "pvqSXApnryowfGE/DpMEMiwND58sg2s76oBsWP4F63GOF9iicRWJ";

    private final Context context;
    private final String symmetricKey;
    private final String cipherText;

    public RSA_cipher(Context context, String symmetricKey, String cipherText) {
        this.context = context;
        this.symmetricKey = symmetricKey;
        this.cipherText = cipherText;
    }

    private String unescape(String input) {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        while (i < input.length()) {
            char delimiter = input.charAt(i);
            i++; // consume letter or backslash

            if (delimiter == '\\' && i < input.length()) {

                // consume first after backslash
                char ch = input.charAt(i);
                i++;

                if (ch == '\\' || ch == '/' || ch == '"' || ch == '\'') {
                    builder.append(ch);
                } else if (ch == 'n') builder.append('\n');
                else if (ch == 'r') builder.append('\r');
                else if (ch == 't') builder.append('\t');
                else if (ch == 'b') builder.append('\b');
                else if (ch == 'f') builder.append('\f');
                else if (ch == 'u') {

                    StringBuilder hex = new StringBuilder();

                    // expect 4 digits
                    if (i + 4 > input.length()) {
                        throw new RuntimeException("Not enough unicode digits! ");
                    }
                    for (char x : input.substring(i, i + 4).toCharArray()) {
                        if (!Character.isLetterOrDigit(x)) {
                            throw new RuntimeException("Bad character in unicode escape.");
                        }
                        hex.append(Character.toLowerCase(x));
                    }
                    i += 4; // consume those four digits.

                    int code = Integer.parseInt(hex.toString(), 16);
                    builder.append((char) code);
                } else {
                    throw new RuntimeException("Illegal escape sequence: \\" + ch);
                }
            } else { // it's not a backslash, or it's the last character.
                builder.append(delimiter);
            }
        }

        return builder.toString();
    }

    private PrivateKey extractPrivateKeyFromRawString() {
        PrivateKey privateKey;
        try {
            InputStreamReader isReader = new InputStreamReader(context.getResources().openRawResource(R.raw.keypair));
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }

            String finalPrivateKey = sb.toString()
                    .replaceAll("-----BEGIN RSA PRIVATE KEY-----", "")
                    .replaceAll("-----END RSA PRIVATE KEY-----", "");

            //extract private Key
            KeyFactory kf = KeyFactory.getInstance("RSA");
            EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decode(finalPrivateKey, 0));
            privateKey = kf.generatePrivate(keySpec);

            return privateKey;

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] getEncryptedSymmetricKeyBase64EncodedString() {
        return Base64.decode(unescape(symmetricKey), 0);
    }

    private int[] decryptString() {
        int[] signedArray;
        try {
            Cipher output = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
            output.init(Cipher.DECRYPT_MODE, extractPrivateKeyFromRawString());

            CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(getEncryptedSymmetricKeyBase64EncodedString()), output);
            ArrayList<Byte> values = new ArrayList<>();
            int nextByte;
            while ((nextByte = cipherInputStream.read()) != -1) {
                values.add((byte) nextByte);
            }

            byte[] decryptedSymKey = new byte[values.size()];
            signedArray = new int[values.size()];

            for (int i = 0; i < decryptedSymKey.length; i++) {
                decryptedSymKey[i] = values.get(i);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    signedArray[i] = Byte.toUnsignedInt(decryptedSymKey[i]);
                }
            }

            return signedArray;

        } catch (Exception e) {
            Log.e(TAG, "decryptString: excetpiton " + e.getMessage());
            return null;
        }
    }

    public void decryptedNif() throws Exception {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (int i : decryptString()) {
            jsonArray.put(i);
        }
        jsonObject.put("cipherText", unescape(cipherText));
        jsonObject.put("symmetricKey", jsonArray);
//        Log.e("mTAG", "decryptedNif: " + jsonObject.toString());

        APIInterface apiInterface = APIClient.getApiInstance();
        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        apiInterface.decryptNif(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (!response.isSuccessful() && response.body() == null) {
                    try {
                        Log.e(TAG, "onResponse: " + response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }


                int responseCode = response.code();

                Log.e(TAG, "onResponse: " + responseCode);
                try {
                    Log.e(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
