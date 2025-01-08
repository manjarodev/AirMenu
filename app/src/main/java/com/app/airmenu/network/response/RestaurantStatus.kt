package com.app.airmenu.network.response


import com.google.gson.annotations.SerializedName

data class RestaurantStatus(
    @SerializedName("offlineReason")
    val offlineReason: String,
    @SerializedName("status")
    val status: String
)