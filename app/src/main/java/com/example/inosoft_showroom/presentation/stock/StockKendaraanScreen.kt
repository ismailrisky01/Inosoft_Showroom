package com.example.inosoft_showroom.presentation.stock

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inosoft_showroom.presentation.component.Appbar
import com.example.inosoft_showroom.presentation.component.ItemStockMotor
import com.example.inosoft_showroom.presentation.util.Screen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockKendaraanScreen(navController: NavController? = null) {
    val viewModel: StockViewModel = getViewModel<StockViewModel>()
    val listMotor by viewModel.listMotor.collectAsState(emptyList())
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "Stock Kendaraan", onNavIconPressed = {
                navController?.popBackStack()
            }, page = Screen.StockKendaraanScreen.route)
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
        Column(modifier = Modifier.padding(paddding).fillMaxHeight()) {
            LazyColumn(reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)) {
               items(listMotor){
                   ItemStockMotor(motor = it)
               }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StockKendaraanScreenPreview() {
    StockKendaraanScreen()
}