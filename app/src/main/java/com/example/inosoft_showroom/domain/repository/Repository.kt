package com.example.inosoft_showroom.domain.repository

import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor

interface Repository {
    fun addStockMotor(motor: Motor){}
    fun addStockMobil(mobil: Mobil){}
    fun getStockKendaraan(){}
    fun getPenjualanKendaraan(){}
    fun getLaporanPenjualan(){}
}