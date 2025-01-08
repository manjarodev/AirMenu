package com.app.airmenu.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.airmenu.room.model.OrderInfo
import com.app.airmenu.room.model.UberNotification

@Dao
interface UberNotificationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUberNotification(orderInfo: UberNotification)

    @Query("SELECT * FROM uber_notification ORDER BY id DESC")
    suspend fun getAllNotification():List<UberNotification>

}