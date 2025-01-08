package com.app.airmenu.room.database;

import java.lang.System;

@androidx.room.Database(entities = {com.app.airmenu.room.model.OrderInfo.class, com.app.airmenu.room.model.UberNotification.class}, version = 1)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/app/airmenu/room/database/Database;", "Landroidx/room/RoomDatabase;", "()V", "orderDAO", "Lcom/app/airmenu/room/dao/OrderDAO;", "uberNotificationDAO", "Lcom/app/airmenu/room/dao/UberNotificationDAO;", "app_debug"})
public abstract class Database extends androidx.room.RoomDatabase {
    
    public Database() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.app.airmenu.room.dao.OrderDAO orderDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.app.airmenu.room.dao.UberNotificationDAO uberNotificationDAO();
}