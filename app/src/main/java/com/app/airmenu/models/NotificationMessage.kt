package com.app.airmenu.models

import java.io.Serializable

data class NotificationMessage(
    val notificationId: String? = null,
    val orderId: String? = null,
    val storeId: String? = null,
    val time: String? = null,
    val orderDetails: String? = null
):Serializable
