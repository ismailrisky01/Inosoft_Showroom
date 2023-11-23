package com.example.inosoft_showroom.presentation.util

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object StockKendaraanScreen : Screen("stock_kendaraan_screen")
    object PenjualanKendaraanScreen : Screen("penjualan_kendaraan_screen")
    object LaporanPenjualanKendaraanScreen : Screen("laporan_penjualan_kendaraan_screen")
    object AddStockMotor : Screen("add_Stock_motor")
    object DetailStockMotor : Screen("detail_Stock_motor/{${Constants.KENDARAAN_ID}}")

}