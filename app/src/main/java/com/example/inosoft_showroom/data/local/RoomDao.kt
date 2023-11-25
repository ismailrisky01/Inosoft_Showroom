package com.example.inosoft_showroom.data.local

import androidx.room.*
import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor

@Dao
interface MobilDao {
    @Query("SELECT * FROM mobil")
    fun getListMobil():List<Mobil>

    @Query("SELECT * FROM mobil WHERE id = :idMobil")
    fun getMobilById(idMobil: Int): Mobil

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMobil(mobilItem: Mobil)

    @Query("DELETE FROM mobil Where id=:id")
    fun deleteMobil(id:Int)
    @Query("UPDATE mobil SET isSold = :isSold WHERE id = :id")
    fun updateStatusJual(id: Int, isSold: Boolean)
}
@Dao
interface MotorDao {

    @Query("SELECT * FROM motor")
    fun getListMotor():List<Motor>

    @Query("SELECT * FROM motor WHERE id = :idMotor")
    fun getMotorById(idMotor: Int): Motor

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMotor(motorItem: Motor)
    @Update
    suspend fun updateMotor(motor: Motor)
    @Query("UPDATE motor SET isSold = :isSold WHERE id = :id")
     fun updateStatusJual(id: Int, isSold: Boolean)

    @Query("DELETE FROM motor Where id=:id")
    fun deleteMotor(id:Int)
}