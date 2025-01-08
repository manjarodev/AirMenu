package com.app.airmenu.room.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/app/airmenu/room/database/DatabaseHelper;", "", "getAllUberNotification", "", "Lcom/app/airmenu/room/model/UberNotification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderId", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNewUberNotification", "", "uberNotification", "(Lcom/app/airmenu/room/model/UberNotification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrderInfo", "orderInfo", "Lcom/app/airmenu/room/model/OrderInfo;", "(Lcom/app/airmenu/room/model/OrderInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface DatabaseHelper {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertOrderInfo(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.room.model.OrderInfo orderInfo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNewUberNotification(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.room.model.UberNotification uberNotification, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllUberNotification(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.app.airmenu.room.model.UberNotification>> continuation);
}