package com.app.airmenu.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orderInfo")
data class OrderInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "airmenuOrderId")var airmenuOrderId:String,
    @ColumnInfo(name = "uberOrderId")var uberOrderId:String,
    @ColumnInfo(name = "keyFlag")var keyFlag:String)
