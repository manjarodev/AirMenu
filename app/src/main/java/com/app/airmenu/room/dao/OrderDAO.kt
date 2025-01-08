package com.app.airmenu.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.airmenu.room.model.OrderInfo


@Dao
interface OrderDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderInfo: OrderInfo)

    @Query("SELECT airmenuOrderId FROM orderInfo WHERE uberOrderId = :id")
    suspend fun getOrderId(id:String):String



}