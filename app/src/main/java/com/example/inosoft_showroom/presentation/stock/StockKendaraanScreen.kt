package com.example.inosoft_showroom.presentation.stock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inosoft_showroom.R
import com.example.inosoft_showroom.presentation.component.Appbar
import com.example.inosoft_showroom.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockKendaraanScreen(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "History", onNavIconPressed = {
                navController?.popBackStack()
            }, page = Screen.StockKendaraanScreen.route)
        },floatingActionButton = {
            FloatingActionButton(
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")

            }
        },
    ) { paddding ->
        Column(modifier = Modifier.padding(paddding)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StockKendaraanScreenPreview(){
    StockKendaraanScreen()
}