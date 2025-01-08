package com.app.airmenu.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.airmenu.room.dao.OrderDAO
import com.app.airmenu.room.dao.UberNotificationDAO
import com.app.airmenu.room.model.OrderInfo
import com.app.airmenu.room.model.UberNotification

@Database(
    entities = [OrderInfo::class,UberNotification::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun orderDAO(): OrderDAO
    abstract fun uberNotificationDAO() :UberNotificationDAO
}
