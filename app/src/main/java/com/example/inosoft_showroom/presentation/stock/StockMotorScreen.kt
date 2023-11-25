package com.example.inosoft_showroom.presentation.stock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inosoft_showroom.R
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.presentation.component.Appbar
import com.example.inosoft_showroom.presentation.component.DisplayCard
import com.example.inosoft_showroom.presentation.component.ItemStockMotor
import com.example.inosoft_showroom.presentation.util.Constants
import com.example.inosoft_showroom.presentation.util.Screen
import com.example.inosoft_showroom.ui.theme.Blue
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockMotorScreen(navController: NavController? = null) {
    val viewModel: StockViewModel = getViewModel<StockViewModel>()
    val listMotor by viewModel.listMotor.observeAsState(emptyList())
    viewModel.getDataListMotor()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "Stock Motor", onNavIconPressed = {
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

@Preview(showBackground = true)
@Composable
fun StockKendaraanScreenPreview() {
    StockMotorScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailStockKendaraan(navController: NavController? = null, id_kendaraan: String) {
    val viewModel: StockViewModel = getViewModel<StockViewModel>()
    viewModel.getDataMotor(id_kendaraan.toInt())
    val dataMotor by viewModel.dataMotor.observeAsState(Motor("", "", 0.0, "", "", "", ""))

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "Detail Kendaraan", onNavIconPressed = {
                navController?.popBackStack()
            }, page = Screen.StockMotorScreen.route)
        },
    ) { paddding ->
        Column(
            modifier = Modifier
                .padding(paddding)
                .fillMaxHeight()
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DisplayCard(
                "Notes",
                R.drawable.ic_motor,
                Blue
            )
            Text(text = dataMotor.nama)
            Text(text = "Mesin : ${dataMotor.mesin}")
            Text(text = "Harga : ${dataMotor.harga}")
            Text(text = "Tahun Keluaran : ${dataMotor.tahunKeluaran}")
            Text(text = "Tipe Suspensi : ${dataMotor.tipeSuspensi}")
            Text(text = "Tipe Transmisi : ${dataMotor.tipeTransmisi}")
            OutlinedButton(
                contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                onClick = {
                    viewModel.jualMotor(id_kendaraan.toInt())
                    navController?.popBackStack()
                }
            ) {
                Text(text = "Jual", color = Color.White)
            }
        }
    }
}
