package com.example.inosoft_showroom.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.inosoft_showroom.presentation.penjualan.PenjualanMotorScreen
import com.example.inosoft_showroom.presentation.penjualan.PenjualanMobilScreen
import com.example.inosoft_showroom.presentation.stock.AddStockMobil
import com.example.inosoft_showroom.presentation.stock.AddStockScreen
import com.example.inosoft_showroom.presentation.stock.DetailStockKendaraan
import com.example.inosoft_showroom.presentation.stock.DetailStockMobil
import com.example.inosoft_showroom.presentation.stock.StockMobilScreen
import com.example.inosoft_showroom.presentation.stock.StockMotorScreen
import com.example.inosoft_showroom.presentation.util.Constants
import com.example.inosoft_showroom.presentation.util.Screen
import com.example.inosoft_showroom.ui.theme.Inosoft_ShowroomTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val systemUiController = rememberSystemUiController()

            Inosoft_ShowroomTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
                        composable(route = Screen.MainScreen.route,  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        }) {
                            MainScreen(navController)
                        }
                        composable(route = Screen.StockMotorScreen.route,  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right ,
                                animationSpec = tween(400)
                            )
                        }) {
                            StockMotorScreen(navController)
                        }
                        composable(route = Screen.StockMobilScreen.route,  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right ,
                                animationSpec = tween(400)
                            )
                        }) {
                            StockMobilScreen(navController)
                        }
                        composable(route = Screen.PenjualanMotorScreen.route,  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right ,
                                animationSpec = tween(400)
                            )
                        }) {
                            PenjualanMotorScreen(navController)
                        }
                        composable(route = Screen.PenjualanMobilScreen.route,  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right ,
                                animationSpec = tween(400)
                            )
                        }) {
                            PenjualanMobilScreen(navController)
                        }
                        composable(route = Screen.DetailStockMotor.route,   arguments = listOf(
                            navArgument(Constants.KENDARAAN_ID) {
                            type = NavType.StringType
                        }),  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right ,
                                animationSpec = tween(400)
                            )
                        }) {
                            DetailStockKendaraan(navController,it.arguments?.getString(Constants.KENDARAAN_ID)!!)
                        }
                        composable(route = Screen.DetailStockMobil.route,   arguments = listOf(
                            navArgument(Constants.KENDARAAN_ID) {
                                type = NavType.StringType
                            }),  enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(400)
                            )
                        },  exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right ,
                                animationSpec = tween(400)
                            )
                        }) {
                            DetailStockMobil(navController,it.arguments?.getString(Constants.KENDARAAN_ID)!!)
                        }
                        composable(route = Screen.AddStockMotor.route) {
                            AddStockScreen(navController){

                            }
                        }
                        composable(route = Screen.AddStockMobil.route) {
                            AddStockMobil(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Inosoft_ShowroomTheme {
        Greeting("Android")
    }
}