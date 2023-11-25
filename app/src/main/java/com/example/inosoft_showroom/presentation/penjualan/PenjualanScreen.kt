package com.example.inosoft_showroom.presentation.penjualan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inosoft_showroom.presentation.component.Appbar
import com.example.inosoft_showroom.presentation.component.ItemStockMobil
import com.example.inosoft_showroom.presentation.component.ItemStockMotor
import com.example.inosoft_showroom.presentation.stock.StockViewModel
import com.example.inosoft_showroom.presentation.util.Constants
import com.example.inosoft_showroom.presentation.util.Screen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PenjualanMotorScreen(navController: NavController? = null) {
    val viewModel: StockViewModel = getViewModel<StockViewModel>()
    val listMotor by viewModel.listMotor.observeAsState(emptyList())
    viewModel.getDataListMotor(true)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "Laporan Penjualan Motor", onNavIconPressed = {
                navController?.popBackStack()
            }, page = Screen.StockMotorScreen.route)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController!!.navigate(Screen.AddStockMotor.route)

                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")

            }
        },
    ) { paddding ->
        Column(
            modifier = Modifier
                .padding(paddding)
                .fillMaxHeight()
        ) {
            LazyColumn(
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
            ) {
                items(listMotor) {
                    ItemStockMotor(motor = it) {
                        navController!!.navigate(
                            Screen.DetailStockMotor.route.replace(
                                "{${Constants.KENDARAAN_ID}}",
                                "${it.id}"
                            )
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PenjualanMobilScreen(navController: NavController? = null) {
    val viewModel: StockViewModel = getViewModel<StockViewModel>()
    val listMobil by viewModel.listMobil.observeAsState(emptyList())
    viewModel.getDataListMobil(true)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "Laporan Penjualan Mobil", onNavIconPressed = {
                navController?.popBackStack()
            }, page = Screen.StockMotorScreen.route)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController!!.navigate(Screen.AddStockMotor.route)

                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")

            }
        },
    ) { paddding ->
        Column(
            modifier = Modifier
                .padding(paddding)
                .fillMaxHeight()
        ) {
            LazyColumn(
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
            ) {
                items(listMobil) {
                    ItemStockMobil(data = it) {
                        navController!!.navigate(
                            Screen.DetailStockMotor.route.replace(
                                "{${Constants.KENDARAAN_ID}}",
                                "${it.id}"
                            )
                        )
                    }
                }
            }
        }
    }
}
