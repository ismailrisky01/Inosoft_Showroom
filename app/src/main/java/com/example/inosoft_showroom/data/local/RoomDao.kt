package com.example.inosoft_showroom.data.local

import androidx.room.*
import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor

//@Dao
//interface RoomDao {
//    @Query("SELECT * FROM mobil")
//    fun getListMobil():List<Mobil>
//
//    @Query("SELECT * FROM mobil WHERE id = :idMobil")
//    fun getGamesById(idMobil: Int): List<Mobil>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertMobil(mobilItem: Mobil)
//
//    @Query("DELETE FROM mobil Where id=:id")
//    fun deleteMobil(id:Int)
//
//    @Query("SELECT * FROM motor")
//    fun getListMotor():List<Motor>
//
//    @Query("SELECT * FROM motor WHERE id = :idMotor")
//    fun getMotorById(idMotor: Int): List<Motor>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertMotor(mobilItem: Motor)
//
//    @Query("DELETE FROM motor Where id=:id")
//    fun deleteMotor(id:Int)
//}