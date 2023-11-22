package com.example.inosoft_showroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Kendaraan class
@Entity
open class Kendaraan(
    open val tahunKeluaran: String="",
    open val warna: String="",
    open val harga: Double=0.0,
    open val nama: String="",

)

// Mobil class
@Entity
data class Mobil(
    override val tahunKeluaran: String,
    override val warna: String,
    override val nama: String,
    override val harga: Double,
    val mesin: String,
    val kapasitasPenumpang: Int,
    val tipe: String,
    @PrimaryKey val id: Int? = null
) : Kendaraan(tahunKeluaran, warna, harga,nama)

// Motor class
@Entity
data class Motor(
    override val tahunKeluaran: String,
    override val warna: String,
    override val harga: Double,
    override val nama: String,
    val mesin: String,
    val tipeSuspensi: String,
    val tipeTransmisi: String,
    @PrimaryKey val id: Int? = null
) : Kendaraan(tahunKeluaran, warna, harga,nama)

// Penjualan class
@Entity
class Penjualan(
    @PrimaryKey val idPenjualan: Int? = null,
    val tanggal: String,
    val idKendaraan:Int,
    val totalTerjual:Int,
)

// ItemJual class
class StockKendaraan(val idKendaraan:Int,val jumlahStock:Int)