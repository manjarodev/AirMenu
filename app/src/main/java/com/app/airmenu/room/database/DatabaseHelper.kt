package com.app.airmenu.room.database


import com.app.airmenu.room.model.OrderInfo
import com.app.airmenu.room.model.UberNotification

interface DatabaseHelper {

    // OrdersInfo
    suspend fun insertOrderInfo(orderInfo: OrderInfo)
    suspend fun getOrderId(id: String):String

    // Uber Notification
    suspend fun insertNewUberNotification(uberNotification: UberNotification)
    suspend fun getAllUberNotification():List<UberNotification>
}