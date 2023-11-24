package com.example.inosoft_showroom.di

import androidx.room.Room
import com.example.inosoft_showroom.data.local.RoomDatabase
import com.example.inosoft_showroom.data.repository.RepositoryImpl
import com.example.inosoft_showroom.domain.feature.AddStockMotor
import com.example.inosoft_showroom.domain.feature.GetStockMotor
import com.example.inosoft_showroom.domain.repository.Repository
import com.example.inosoft_showroom.domain.usecase.ShowRoomUseCase
import com.example.inosoft_showroom.presentation.stock.StockViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val referenceModules = module {
    single {
        Room.databaseBuilder(
            get(),
            RoomDatabase::class.java,
            RoomDatabase.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }
    single {
        get<RoomDatabase>().motorDao
    }
    single {
        get<RoomDatabase>().mobilDao
    }
    single<Repository> { RepositoryImpl(get(),get()) }
}

val viewModelProject = module {
    // Single instance of the ViewModel
    viewModel { StockViewModel(get()) }
}
val useCaseModules = module {
    single {
        ShowRoomUseCase(addStockMotor = AddStockMotor(get()), getStockMotor = GetStockMotor(get()))
    }
}