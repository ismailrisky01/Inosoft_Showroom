package com.example.inosoft_showroom.domain.repository

import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.data.model.Penjualan

interface Repository {
    fun addStockMotor(motor: Motor)
    fun addStockMobil(mobil: Mobil)
    fun addPenjualan(penjualan: Penjualan)
    fun getStockKendaraanMotor():List<Motor>
    fun getStockKendaraanMobil():List<Mobil>
    fun getPenjualanKendaraan()
    fun getLaporanPenjualan()
}