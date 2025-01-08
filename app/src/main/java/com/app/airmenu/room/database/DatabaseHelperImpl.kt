package com.app.airmenu.room.database

import com.app.airmenu.room.model.OrderInfo
import com.app.airmenu.room.model.UberNotification


class DatabaseHelperImpl(private val database: Database) : DatabaseHelper {

    override suspend fun insertOrderInfo(orderInfo: OrderInfo) = database.orderDAO().insertOrder(orderInfo)
    override suspend fun getOrderId(id: String): String  = database.orderDAO().getOrderId(id)

    override suspend fun insertNewUberNotification(uberNotification: UberNotification) = database.uberNotificationDAO().insertUberNotification(uberNotification)
    override suspend fun getAllUberNotification(): List<UberNotification> = database.uberNotificationDAO().getAllNotification()


}