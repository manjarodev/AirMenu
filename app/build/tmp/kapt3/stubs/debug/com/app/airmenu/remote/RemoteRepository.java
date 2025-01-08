package com.app.airmenu.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ7\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J7\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J7\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J7\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J7\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J7\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ7\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/app/airmenu/remote/RemoteRepository;", "", "api", "Lcom/app/airmenu/remote/AirMenuApi;", "(Lcom/app/airmenu/remote/AirMenuApi;)V", "createMenu", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "action", "", "version", "key", "data", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "getAddressByPlaceId", "Lcom/app/airmenu/models/GoogleAddress;", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDivisionIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocationDivisionEnterprises", "getNotificationAccess", "getOrders", "getPosIds", "loginWithCredentials", "placeOrder", "updateFlags", "app_debug"})
public final class RemoteRepository {
    private final com.app.airmenu.remote.AirMenuApi api = null;
    
    @javax.inject.Inject()
    public RemoteRepository(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.remote.AirMenuApi api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loginWithCredentials(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPosIds(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFlags(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    org.json.JSONObject data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOrders(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    org.json.JSONObject data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    org.json.JSONObject data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    org.json.JSONObject data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDivisionIds(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLocationDivisionEnterprises(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createUser(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    org.json.JSONObject data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNotificationAccess(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAddressByPlaceId(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.app.airmenu.models.GoogleAddress>> continuation) {
        return null;
    }
}