package com.example.inosoft_showroom.presentation.util

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object StockKendaraanScreen : Screen("stock_kendaraan_screen")

}