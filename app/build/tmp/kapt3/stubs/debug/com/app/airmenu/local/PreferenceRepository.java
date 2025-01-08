package com.app.airmenu.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\rJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0013J\u000e\u0010)\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0013J\u000e\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0013J\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00100\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0013J\u000e\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/app/airmenu/local/PreferenceRepository;", "", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "clearSession", "", "getDivisionIdsResponse", "Lcom/app/airmenu/models/DivisionIdsResponse;", "getLoginResponse", "Lcom/app/airmenu/models/LoginResponse;", "getNotificationResponse", "Lcom/app/airmenu/models/NotificationAccessResponse;", "getPosIdsResponse", "Lcom/app/airmenu/models/PosIdsResponse;", "getSelectedDivisionId", "", "getSelectedDivisionIdMenu", "getSelectedDivisionName", "getSelectedDivisionNameMenu", "getSelectedEnterPriseName", "getSelectedEnterpriseId", "getSelectedPOSId", "getSessionId", "getUserEmail", "getUserPassword", "saveDivisionIds", "divisionIdsResponse", "saveLoginResponse", "response", "saveNotificationResponse", "savePosIds", "savePushNotificationToken", "", "token", "saveSelectedDivisonId", "divisionId", "saveSelectedDivisonIdMenu", "saveSelectedDivisonName", "saveSelectedDivisonNameMenu", "saveSelectedEnterpriseId", "id", "saveSelectedEnterpriseName", "saveSelectedPOSId", "posId", "saveSessionId", "saveUserEmail", "email", "saveUserPassword", "password", "Companion", "app_debug"})
public final class PreferenceRepository {
    private final android.app.Application app = null;
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.app.airmenu.local.PreferenceRepository.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.app.airmenu.local.PreferenceRepository instance;
    
    @javax.inject.Inject()
    public PreferenceRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super();
    }
    
    public final void saveSessionId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void clearSession() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSessionId() {
        return null;
    }
    
    public final void saveUserEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void saveUserPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserPassword() {
        return null;
    }
    
    public final void saveLoginResponse(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.models.LoginResponse response) {
    }
    
    public final void saveNotificationResponse(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.models.NotificationAccessResponse response) {
    }
    
    public final void savePosIds(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.models.PosIdsResponse response) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.app.airmenu.models.LoginResponse getLoginResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.app.airmenu.models.PosIdsResponse getPosIdsResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.app.airmenu.models.NotificationAccessResponse getNotificationResponse() {
        return null;
    }
    
    public final void saveSelectedEnterpriseId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void saveSelectedEnterpriseName(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedEnterPriseName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedEnterpriseId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedDivisionIdMenu() {
        return null;
    }
    
    public final boolean savePushNotificationToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return false;
    }
    
    public final boolean saveSelectedPOSId(@org.jetbrains.annotations.NotNull()
    java.lang.String posId) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedPOSId() {
        return null;
    }
    
    public final void saveDivisionIds(@org.jetbrains.annotations.Nullable()
    com.app.airmenu.models.DivisionIdsResponse divisionIdsResponse) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.app.airmenu.models.DivisionIdsResponse getDivisionIdsResponse() {
        return null;
    }
    
    public final boolean saveSelectedDivisonId(@org.jetbrains.annotations.NotNull()
    java.lang.String divisionId) {
        return false;
    }
    
    public final boolean saveSelectedDivisonIdMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String divisionId) {
        return false;
    }
    
    public final boolean saveSelectedDivisonName(@org.jetbrains.annotations.NotNull()
    java.lang.String divisionId) {
        return false;
    }
    
    public final boolean saveSelectedDivisonNameMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String divisionId) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedDivisionName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedDivisionNameMenu() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedDivisionId() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/app/airmenu/local/PreferenceRepository$Companion;", "", "()V", "instance", "Lcom/app/airmenu/local/PreferenceRepository;", "getInstance", "app", "Landroid/app/Application;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.airmenu.local.PreferenceRepository getInstance(@org.jetbrains.annotations.NotNull()
        android.app.Application app) {
            return null;
        }
    }
}