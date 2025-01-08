package com.app.airmenu.ui.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\tJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u001a\u0010#\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\tJ\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\tH\u0002J\u0012\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020\tH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/app/airmenu/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteRepository", "Lcom/app/airmenu/remote/RemoteRepository;", "preferenceRepository", "Lcom/app/airmenu/local/PreferenceRepository;", "(Lcom/app/airmenu/remote/RemoteRepository;Lcom/app/airmenu/local/PreferenceRepository;)V", "error", "Landroidx/lifecycle/LiveData;", "", "errorDescription", "Landroidx/lifecycle/MutableLiveData;", "getErrorDescription", "()Landroidx/lifecycle/MutableLiveData;", "errorDescriptionLogin", "getErrorDescriptionLogin", "errorLogin", "requestState", "Lcom/app/airmenu/utils/RequestState;", "getRequestState", "requestStateLogin", "getRequestStateLogin", "state", "stateLogin", "formatToJson", "sessionId", "enterpriseId", "posId", "formatToJsonLogin", "email", "password", "getSelectedDivisionId", "getSocketInfo", "", "login", "loginWithCredentials", "parseToJsonObj", "Lcom/app/airmenu/models/NotificationAccessResponse;", "json", "parseToJsonObjLogin", "Lcom/app/airmenu/models/LoginResponse;", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.airmenu.remote.RemoteRepository remoteRepository = null;
    private final com.app.airmenu.local.PreferenceRepository preferenceRepository = null;
    private final androidx.lifecycle.LiveData<com.app.airmenu.utils.RequestState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> requestState = null;
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorDescription = null;
    private final androidx.lifecycle.LiveData<com.app.airmenu.utils.RequestState> stateLogin = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> requestStateLogin = null;
    private final androidx.lifecycle.LiveData<java.lang.String> errorLogin = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorDescriptionLogin = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.remote.RemoteRepository remoteRepository, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.local.PreferenceRepository preferenceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> getRequestState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> getRequestStateLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorDescriptionLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedDivisionId() {
        return null;
    }
    
    public final void getSocketInfo() {
    }
    
    private final java.lang.String formatToJson(java.lang.String sessionId, java.lang.String enterpriseId, java.lang.String posId) {
        return null;
    }
    
    private final com.app.airmenu.models.NotificationAccessResponse parseToJsonObj(java.lang.String json) {
        return null;
    }
    
    public final void login() {
    }
    
    public final void loginWithCredentials(@org.jetbrains.annotations.Nullable()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.String password) {
    }
    
    private final java.lang.String formatToJsonLogin(java.lang.String email, java.lang.String password) {
        return null;
    }
    
    private final com.app.airmenu.models.LoginResponse parseToJsonObjLogin(java.lang.String json) {
        return null;
    }
}