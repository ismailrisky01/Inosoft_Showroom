package com.example.inosoft_showroom

import android.app.Application
import com.example.inosoft_showroom.di.referenceModules
import com.example.inosoft_showroom.di.useCaseModules
import com.example.inosoft_showroom.di.viewModelProject
import com.example.inosoft_showroom.presentation.stock.StockViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(viewModelProject,referenceModules, useCaseModules)
        }
    }
}
