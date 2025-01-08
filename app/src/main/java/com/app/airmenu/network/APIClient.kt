package com.imprint.app.network

import com.app.airmenu.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object ApiClient {

    var token: String = ""
    var okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("Authorization", token)
                    .header("Content-Type", "application/json")
                   // .header("X-Requested-With", "XMLHttpRequest")
                return@Interceptor chain.proceed(builder.build())
            }
        )

        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        connectTimeout(55, TimeUnit.SECONDS)
        readTimeout(55, TimeUnit.SECONDS)
        writeTimeout(55,TimeUnit.SECONDS)

    }.build()

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    val retrofitService: APIInterface by lazy {
        retrofit().create(APIInterface::class.java)
    }

}