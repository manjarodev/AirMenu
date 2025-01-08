package com.app.airmenu.network.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/app/airmenu/network/response/POSStatus;", "", "autoAcceptEnabled", "", "onlineStatus", "", "orderReleaseEnabled", "posIntegrationEnabled", "posMetadata", "Lcom/app/airmenu/network/response/POSStatus$PosMetadata;", "storeId", "(ZLjava/lang/String;ZZLcom/app/airmenu/network/response/POSStatus$PosMetadata;Ljava/lang/String;)V", "getAutoAcceptEnabled", "()Z", "getOnlineStatus", "()Ljava/lang/String;", "getOrderReleaseEnabled", "getPosIntegrationEnabled", "getPosMetadata", "()Lcom/app/airmenu/network/response/POSStatus$PosMetadata;", "getStoreId", "PosMetadata", "app_debug"})
public final class POSStatus {
    @com.google.gson.annotations.SerializedName(value = "auto_accept_enabled")
    private final boolean autoAcceptEnabled = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "online_status")
    private final java.lang.String onlineStatus = null;
    @com.google.gson.annotations.SerializedName(value = "order_release_enabled")
    private final boolean orderReleaseEnabled = false;
    @com.google.gson.annotations.SerializedName(value = "pos_integration_enabled")
    private final boolean posIntegrationEnabled = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "pos_metadata")
    private final com.app.airmenu.network.response.POSStatus.PosMetadata posMetadata = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "store_id")
    private final java.lang.String storeId = null;
    
    public POSStatus(boolean autoAcceptEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String onlineStatus, boolean orderReleaseEnabled, boolean posIntegrationEnabled, @org.jetbrains.annotations.NotNull()
    com.app.airmenu.network.response.POSStatus.PosMetadata posMetadata, @org.jetbrains.annotations.NotNull()
    java.lang.String storeId) {
        super();
    }
    
    public final boolean getAutoAcceptEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOnlineStatus() {
        return null;
    }
    
    public final boolean getOrderReleaseEnabled() {
        return false;
    }
    
    public final boolean getPosIntegrationEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.app.airmenu.network.response.POSStatus.PosMetadata getPosMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStoreId() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/app/airmenu/network/response/POSStatus$PosMetadata;", "", "()V", "app_debug"})
    public static final class PosMetadata {
        
        public PosMetadata() {
            super();
        }
    }
}