package com.app.airmenu.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/app/airmenu/utils/ConnectivityWatcher;", "Landroidx/lifecycle/LiveData;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "createBroadcastReceiver", "createNetworkCallback", "onActive", "", "onInactive", "app_debug"})
public final class ConnectivityWatcher extends androidx.lifecycle.LiveData<java.lang.Boolean> {
    private final android.content.Context context = null;
    private android.net.ConnectivityManager.NetworkCallback networkCallback;
    private android.content.BroadcastReceiver broadcastReceiver;
    
    public ConnectivityWatcher(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onActive() {
    }
    
    @java.lang.Override()
    protected void onInactive() {
    }
    
    private final android.net.ConnectivityManager.NetworkCallback createNetworkCallback() {
        return null;
    }
    
    private final android.content.BroadcastReceiver createBroadcastReceiver() {
        return null;
    }
}