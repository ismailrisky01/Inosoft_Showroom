package com.example.inosoft_showroom.data.repository

import com.example.inosoft_showroom.data.local.MobilDao
import com.example.inosoft_showroom.data.local.MotorDao
import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.data.model.Penjualan
import com.example.inosoft_showroom.domain.repository.Repository
import com.example.inosoft_showroom.presentation.util.myLog

class RepositoryImpl(private val motorDao: MotorDao,private val mobilDao: MobilDao):Repository {
    override fun addStockMotor(motor: Motor) {
        motorDao.insertMotor(motor)
        myLog("Insert Data Motor")
    }

    override fun addStockMobil(mobil: Mobil) {
        mobilDao.insertMobil(mobil)
    }

    override fun addPenjualan(penjualan: Penjualan) {
        TODO("Not yet implemented")
    }

    override fun getStockKendaraanMotor(): List<Motor> {
        return motorDao.getListMotor()
    }

    override fun getStockKendaraanMobil(): List<Mobil> {
        return mobilDao.getListMobil()

    }

    override fun getPenjualanKendaraan() {
        TODO("Not yet implemented")
    }

    override fun getLaporanPenjualan() {
        TODO("Not yet implemented")
    }
}