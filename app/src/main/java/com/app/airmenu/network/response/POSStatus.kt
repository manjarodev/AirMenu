package com.app.airmenu.network.response


import com.google.gson.annotations.SerializedName

class POSStatus(
    @SerializedName("auto_accept_enabled")
    val autoAcceptEnabled: Boolean,
    @SerializedName("online_status")
    val onlineStatus: String,
    @SerializedName("order_release_enabled")
    val orderReleaseEnabled: Boolean,
    @SerializedName("pos_integration_enabled")
    val posIntegrationEnabled: Boolean,
    @SerializedName("pos_metadata")
    val posMetadata: PosMetadata,
    @SerializedName("store_id")
    val storeId: String
) {
    class PosMetadata(
    )
}