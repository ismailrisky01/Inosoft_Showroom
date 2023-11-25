package com.example.inosoft_showroom.presentation.util

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object StockMotorScreen : Screen("stock_motor_screen")
    object StockMobilScreen : Screen("stock_mobil_screen")
    object PenjualanMotorScreen : Screen("penjualan_motor_screen")
    object PenjualanMobilScreen : Screen("penjualan_mobil_screen")
    object LaporanPenjualanKendaraanScreen : Screen("laporan_penjualan_kendaraan_screen")
    object AddStockMotor : Screen("add_Stock_motor")
    object AddStockMobil : Screen("add_Stock_mobil")
    object DetailStockMotor : Screen("detail_Stock_motor/{${Constants.KENDARAAN_ID}}")
    object DetailStockMobil : Screen("detail_Stock_mobil/{${Constants.KENDARAAN_ID}}")

}