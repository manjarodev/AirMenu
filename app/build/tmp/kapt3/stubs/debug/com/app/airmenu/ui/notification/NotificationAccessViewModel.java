package com.app.airmenu.ui.notification;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/app/airmenu/ui/notification/NotificationAccessViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteRepository", "Lcom/app/airmenu/remote/RemoteRepository;", "preferenceRepository", "Lcom/app/airmenu/local/PreferenceRepository;", "(Lcom/app/airmenu/remote/RemoteRepository;Lcom/app/airmenu/local/PreferenceRepository;)V", "error", "Landroidx/lifecycle/LiveData;", "", "errorMessage", "Landroidx/lifecycle/MutableLiveData;", "getErrorMessage", "()Landroidx/lifecycle/MutableLiveData;", "requestState", "Lcom/app/airmenu/utils/RequestState;", "getRequestState", "state", "formatToJson", "sessionId", "enterpriseId", "getDivisionIds", "", "getDivisionIdsResponse", "Lcom/app/airmenu/models/DivisionIdsResponse;", "getPosIdAtPosition", "position", "", "getPosIdsList", "", "parseToJsonObj", "json", "saveSelectedPOSId", "posId", "app_debug"})
public final class NotificationAccessViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.airmenu.remote.RemoteRepository remoteRepository = null;
    private final com.app.airmenu.local.PreferenceRepository preferenceRepository = null;
    private final androidx.lifecycle.LiveData<com.app.airmenu.utils.RequestState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> requestState = null;
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorMessage = null;
    
    @javax.inject.Inject()
    public NotificationAccessViewModel(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.remote.RemoteRepository remoteRepository, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.local.PreferenceRepository preferenceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> getRequestState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getPosIdsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPosIdAtPosition(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.app.airmenu.models.DivisionIdsResponse getDivisionIdsResponse() {
        return null;
    }
    
    public final void getDivisionIds() {
    }
    
    private final java.lang.String formatToJson(java.lang.String sessionId, java.lang.String enterpriseId) {
        return null;
    }
    
    private final com.app.airmenu.models.DivisionIdsResponse parseToJsonObj(java.lang.String json) {
        return null;
    }
    
    public final void saveSelectedPOSId(@org.jetbrains.annotations.NotNull()
    java.lang.String posId) {
    }
}