package com.app.airmenu.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014J-\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060 2\u0006\u0010!\u001a\u00020\"H\u0016\u00a2\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/app/airmenu/ui/Splahsh;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "SPLASH_DELAY", "", "TAG", "", "binding", "Lcom/app/airmenu/databinding/ActivitySplahshBinding;", "mDelayHandler", "Landroid/os/Handler;", "mRunnable", "Ljava/lang/Runnable;", "sessionManager", "Lcom/app/airmenu/session/SessionManager;", "getSessionManager", "()Lcom/app/airmenu/session/SessionManager;", "setSessionManager", "(Lcom/app/airmenu/session/SessionManager;)V", "checkIfAlreadyhavePermission", "", "getToken", "", "s", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestForSpecificPermission", "app_debug"})
public final class Splahsh extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String TAG = "Splash";
    private com.app.airmenu.databinding.ActivitySplahshBinding binding;
    private android.os.Handler mDelayHandler;
    private final long SPLASH_DELAY = 500L;
    @org.jetbrains.annotations.Nullable()
    private com.app.airmenu.session.SessionManager sessionManager;
    private final java.lang.Runnable mRunnable = null;
    
    public Splahsh() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.app.airmenu.session.SessionManager getSessionManager() {
        return null;
    }
    
    public final void setSessionManager(@org.jetbrains.annotations.Nullable()
    com.app.airmenu.session.SessionManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getToken(java.lang.String s) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final boolean checkIfAlreadyhavePermission() {
        return false;
    }
    
    private final void requestForSpecificPermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
}