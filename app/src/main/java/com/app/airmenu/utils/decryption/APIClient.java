package com.app.airmenu.utils.decryption;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    static APIInterface INSTANCE = null;

    public static APIInterface getApiInstance() {
        if (INSTANCE == null) {
            INSTANCE = APIClient.getClient().create(APIInterface.class);
        }
        return INSTANCE;
    }

    private static Retrofit getClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl("https://us-central1-airmenu-connector.cloudfunctions.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}
