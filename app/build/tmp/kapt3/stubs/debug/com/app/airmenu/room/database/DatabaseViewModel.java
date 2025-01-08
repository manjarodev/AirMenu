package com.app.airmenu.room.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\u000e0\t0\rJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/app/airmenu/room/database/DatabaseViewModel;", "Landroidx/lifecycle/ViewModel;", "dbHleper", "Lcom/app/airmenu/room/database/DatabaseHelper;", "(Lcom/app/airmenu/room/database/DatabaseHelper;)V", "TAG", "", "notifications", "Landroidx/lifecycle/MutableLiveData;", "Lcom/app/airmenu/room/database/Resource;", "Ljava/util/ArrayList;", "Lcom/app/airmenu/room/model/UberNotification;", "getAllNotifications", "Landroidx/lifecycle/LiveData;", "Lkotlin/collections/ArrayList;", "insertUberNotification", "", "uberNotification", "app_debug"})
public final class DatabaseViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.airmenu.room.database.DatabaseHelper dbHleper = null;
    private final java.lang.String TAG = null;
    private final androidx.lifecycle.MutableLiveData<com.app.airmenu.room.database.Resource<java.util.ArrayList<com.app.airmenu.room.model.UberNotification>>> notifications = null;
    
    public DatabaseViewModel(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.room.database.DatabaseHelper dbHleper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.app.airmenu.room.database.Resource<java.util.ArrayList<com.app.airmenu.room.model.UberNotification>>> getAllNotifications() {
        return null;
    }
    
    public final void insertUberNotification(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.room.model.UberNotification uberNotification) {
    }
}