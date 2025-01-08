package com.app.airmenu.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "uber_notification")
data class UberNotification(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "uber_order_id") var orderId:String,
    @ColumnInfo(name = "uber_store_id") var storeId:String,
    @ColumnInfo(name = "timestamp") var timemstamp:String,
    @ColumnInfo(name = "local_time") var localTime:String,
    @ColumnInfo(name = "status") var status:String
)