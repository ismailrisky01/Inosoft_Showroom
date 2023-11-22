package com.example.inosoft_showroom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.data.model.Penjualan

@Database(
    entities = [Mobil::class, Motor::class,Penjualan::class],
    version = 1
)
abstract class RoomDatabase :RoomDatabase() {
    abstract val motorDao:MotorDao
    abstract val mobilDao:MobilDao

    companion object {
        const val DATABASE_NAME = "room_db"
    }
}