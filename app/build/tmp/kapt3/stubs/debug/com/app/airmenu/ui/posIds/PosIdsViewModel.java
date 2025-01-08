package com.app.airmenu.ui.posIds;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/app/airmenu/ui/posIds/PosIdsViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteRepository", "Lcom/app/airmenu/remote/RemoteRepository;", "prefRepository", "Lcom/app/airmenu/local/PreferenceRepository;", "(Lcom/app/airmenu/remote/RemoteRepository;Lcom/app/airmenu/local/PreferenceRepository;)V", "requestState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/app/airmenu/utils/RequestState;", "getRequestState", "()Landroidx/lifecycle/MutableLiveData;", "state", "Landroidx/lifecycle/LiveData;", "formatToJson", "", "sessionId", "enterpriseId", "getEnterpriseId", "pos", "", "getEnterpriseName", "getEnterpriseNames", "", "getPosIds", "", "parseToJsonObj", "Lcom/app/airmenu/models/PosIdsResponse;", "json", "saveEnterPriseName", "id", "saveEnterpriseId", "saveSelectedDivisionIdMenu", "divisionId", "saveSelectedDivisionNameMenu", "app_debug"})
public final class PosIdsViewModel extends androidx.lifecycle.ViewModel {
    private final com.app.airmenu.remote.RemoteRepository remoteRepository = null;
    private final com.app.airmenu.local.PreferenceRepository prefRepository = null;
    private final androidx.lifecycle.LiveData<com.app.airmenu.utils.RequestState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> requestState = null;
    
    @javax.inject.Inject()
    public PosIdsViewModel(@org.jetbrains.annotations.NotNull()
    com.app.airmenu.remote.RemoteRepository remoteRepository, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.local.PreferenceRepository prefRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.app.airmenu.utils.RequestState> getRequestState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getEnterpriseNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnterpriseId(int pos) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnterpriseName(int pos) {
        return null;
    }
    
    public final void saveEnterpriseId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void saveEnterPriseName(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    public final void getPosIds() {
    }
    
    public final void saveSelectedDivisionNameMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String divisionId) {
    }
    
    public final void saveSelectedDivisionIdMenu(@org.jetbrains.annotations.NotNull()
    java.lang.String divisionId) {
    }
    
    private final java.lang.String formatToJson(java.lang.String sessionId, java.lang.String enterpriseId) {
        return null;
    }
    
    private final com.app.airmenu.models.PosIdsResponse parseToJsonObj(java.lang.String json) {
        return null;
    }
}