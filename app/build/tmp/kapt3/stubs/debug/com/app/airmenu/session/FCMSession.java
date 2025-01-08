package com.app.airmenu.session;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lcom/app/airmenu/session/FCMSession;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PRIVATE_MODE", "", "getPRIVATE_MODE", "()I", "setPRIVATE_MODE", "(I)V", "getContext", "()Landroid/content/Context;", "setContext", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "token", "", "fcmToken", "getFcmToken", "()Ljava/lang/String;", "setFcmToken", "(Ljava/lang/String;)V", "pref", "Landroid/content/SharedPreferences;", "getPref", "()Landroid/content/SharedPreferences;", "setPref", "(Landroid/content/SharedPreferences;)V", "Companion", "app_debug"})
public final class FCMSession {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    private android.content.SharedPreferences pref;
    @org.jetbrains.annotations.NotNull()
    private android.content.SharedPreferences.Editor editor;
    private int PRIVATE_MODE = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.app.airmenu.session.FCMSession.Companion Companion = null;
    private static final java.lang.String PREF_NAME = "com.app.airmenu.fcm";
    
    public FCMSession(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPref() {
        return null;
    }
    
    public final void setPref(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences.Editor p0) {
    }
    
    public final int getPRIVATE_MODE() {
        return 0;
    }
    
    public final void setPRIVATE_MODE(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFcmToken() {
        return null;
    }
    
    public final void setFcmToken(@org.jetbrains.annotations.Nullable()
    java.lang.String token) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/app/airmenu/session/FCMSession$Companion;", "", "()V", "PREF_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}