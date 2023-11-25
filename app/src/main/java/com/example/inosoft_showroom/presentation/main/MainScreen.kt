package com.example.inosoft_showroom.presentation.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inosoft_showroom.presentation.component.Appbar
import com.example.inosoft_showroom.presentation.component.SpaceRegularCard
import com.example.inosoft_showroom.presentation.component.SpaceWideCard
import com.example.inosoft_showroom.presentation.util.Screen
import com.example.inosoft_showroom.ui.theme.Blue
import com.example.inosoft_showroom.ui.theme.Purple
import com.example.inosoft_showroom.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController   ){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val scrollState = rememberLazyListState()

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Black,
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Appbar(title = "UNISOFT", onNavIconPressed = {
                scope.launch {
                    drawerState.open()
                }
            })
        },
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                Row {
                    SpaceRegularCard(
                        modifier = Modifier.weight(1f, fill = true),
                        title = "Stock Motor",
                        image = com.example.inosoft_showroom.R.drawable.ic_motor,
                        backgroundColor = Blue
                    ){
                        navController.navigate(Screen.StockMotorScreen.route)
                    }
                    SpaceRegularCard(
                        modifier = Modifier.weight(1f, fill = true),
                        title = "Stock Mobil",
                        image = com.example.inosoft_showroom.R.drawable.ic_mobil,
                        backgroundColor = Red
                    ){
                        navController.navigate(
                            Screen.StockMobilScreen.route
                        )
                    }
                }
            }
            item {
                SpaceWideCard(
                    title = "Laporan Penjualan Motor",
                    image = com.example.inosoft_showroom.R.drawable.notes_img,
                    backgroundColor = Purple
                ){
                    navController.navigate(
                        Screen.PenjualanMotorScreen.route
                    )
                }
            }
            item {
                SpaceWideCard(
                    title = "Laporan Penjualan Mobil",
                    image = com.example.inosoft_showroom.R.drawable.notes_img,
                    backgroundColor = Color.Green
                ){
                    navController.navigate(
                        Screen.PenjualanMobilScreen.route
                    )
                }
            }
            item { Spacer(Modifier.height(60.dp)) }
        }
    }
}