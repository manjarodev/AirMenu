package com.app.airmenu.room.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: Database? = null

    fun getInstance(context: Context): Database {
        if (INSTANCE == null) {
            synchronized(Database::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            "airmenu-database"
        ).build()
}