package com.example.inosoft_showroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Kendaraan class
open class Kendaraan(
    val tahunKeluaran: String,
    open val warna: String,
    open val harga: Double
)

// Mobil class
data class Mobil(
    val tahun: String,
    override val warna: String,
    override val harga: Double,
    val mesin: String,
    val kapasitasPenumpang: Int,
    val tipe: String,
     val id: Int? = null
) : Kendaraan(tahun, warna, harga)

// Motor class
class Motor(
    tahun: String,
    warna: String,
    harga: Double,
    val mesin: String,
    val tipeSuspensi: String,
    val tipeTransmisi: String,
   val id: Int? = null
) : Kendaraan(tahun, warna, harga)

// Penjualan class
class Penjualan(
    val idPenjualan: Int? = null,
    val tanggal: String,
    val totalHarga: Double,
    val itemPenjualan: List<ItemJual>
)

// ItemJual class
class ItemJual(
    val idItem: Int? = null,
    val jumlah: Int,
    val subtotal: Double,
    val produk: Produk
)

// Produk class (digunakan oleh ItemJual)
class Produk(
    val idProduk: Int? = null,
    val nama: String,
    val harga: Double
)
class StockMotor(val listMotor:List<Motor>)
class StockMobil(val listMobil:List<Mobil>)