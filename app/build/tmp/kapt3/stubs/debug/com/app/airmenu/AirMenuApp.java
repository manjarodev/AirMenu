package com.app.airmenu;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/app/airmenu/AirMenuApp;", "Landroid/app/Application;", "()V", "config", "Lcom/elvishew/xlog/LogConfiguration;", "kotlin.jvm.PlatformType", "getConfig", "()Lcom/elvishew/xlog/LogConfiguration;", "setConfig", "(Lcom/elvishew/xlog/LogConfiguration;)V", "onCreate", "", "setConnectivityListener", "listener", "Lcom/app/airmenu/utils/NetworkWatcher$ConnectivityReceiverListener;", "Companion", "app_debug"})
@dagger.hilt.android.HiltAndroidApp()
public final class AirMenuApp extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.airmenu.AirMenuApp.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.app.airmenu.AirMenuApp instancee;
    private static boolean isInForeGround = true;
    private com.elvishew.xlog.LogConfiguration config;
    
    public AirMenuApp() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public final com.elvishew.xlog.LogConfiguration getConfig() {
        return null;
    }
    
    public final void setConfig(com.elvishew.xlog.LogConfiguration p0) {
    }
    
    public final void setConnectivityListener(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.utils.NetworkWatcher.ConnectivityReceiverListener listener) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/app/airmenu/AirMenuApp$Companion;", "", "()V", "instancee", "Lcom/app/airmenu/AirMenuApp;", "getInstancee", "()Lcom/app/airmenu/AirMenuApp;", "setInstancee", "(Lcom/app/airmenu/AirMenuApp;)V", "isInForeGround", "", "()Z", "setInForeGround", "(Z)V", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.app.airmenu.AirMenuApp getInstancee() {
            return null;
        }
        
        public final void setInstancee(@org.jetbrains.annotations.Nullable()
        com.app.airmenu.AirMenuApp p0) {
        }
        
        public final boolean isInForeGround() {
            return false;
        }
        
        public final void setInForeGround(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.Synchronized()
        public final synchronized com.app.airmenu.AirMenuApp getInstance() {
            return null;
        }
    }
}