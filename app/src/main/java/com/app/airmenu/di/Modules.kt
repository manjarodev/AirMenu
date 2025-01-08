package com.app.airmenu.di

import android.content.Context
import android.provider.SyncStateContract
import com.app.airmenu.AirMenuApp
import com.app.airmenu.broadcast.OnServiceDestroyReceiver
import com.app.airmenu.local.PreferenceRepository
import com.app.airmenu.remote.AirMenuApi
import com.app.airmenu.remote.RemoteRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Modules {
    private var okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("Accept", "application/json")
                return@Interceptor chain.proceed(builder.build())
            }
        )
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        connectTimeout(55, TimeUnit.SECONDS)
        readTimeout(55, TimeUnit.SECONDS)
        writeTimeout(55, TimeUnit.SECONDS)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder()
        /// .setLenient()
        .create()

    @Provides
    fun provideApiService(retrofit: Retrofit): AirMenuApi =
        retrofit.create(AirMenuApi::class.java)

    @Singleton
    @Provides
    fun provideRemoteRepository(apiService: AirMenuApi) = RemoteRepository(apiService)

    @Singleton
    @Provides
    fun provideServiceReceiver() = OnServiceDestroyReceiver()

}

private const val API_BASE_URL = "http://www.airmenu.com/"