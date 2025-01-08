package com.app.airmenu.network.response


import com.google.gson.annotations.SerializedName

class POSAvailability(
    @SerializedName("currentStatus")
    val currentStatus: String,
    @SerializedName("previousStatus")
    val previousStatus: String
)