package com.example.inosoft_showroom.domain.repository

import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.data.model.Penjualan

interface Repository {
    fun addStockMotor(motor: Motor)
    fun updateStockMotor(id: Int,isSold:Boolean)
    fun addStockMobil(mobil: Mobil)
    fun updateStockMobil(id: Int,isSold:Boolean)

    fun addPenjualan(penjualan: Penjualan)

    fun getStockKendaraanMotor():List<Motor>
    fun getDetailKendaraanMotor(id:Int):Motor
    fun getDetailKendaraanMobil(id:Int):Mobil
    fun getStockKendaraanMobil():List<Mobil>
    fun getPenjualanKendaraan()
    fun getLaporanPenjualan()
}