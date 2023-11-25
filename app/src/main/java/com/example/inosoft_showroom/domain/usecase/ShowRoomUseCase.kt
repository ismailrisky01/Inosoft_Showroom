package com.example.inosoft_showroom.domain.usecase

import com.example.inosoft_showroom.domain.feature.AddStockMobil
import com.example.inosoft_showroom.domain.feature.AddStockMotor
import com.example.inosoft_showroom.domain.feature.GetDetailMotor
import com.example.inosoft_showroom.domain.feature.GetDetalMobil
import com.example.inosoft_showroom.domain.feature.GetStockMobil
import com.example.inosoft_showroom.domain.feature.GetStockMotor
import com.example.inosoft_showroom.domain.feature.UpdateStockMobil
import com.example.inosoft_showroom.domain.feature.UpdateStockMotor

data class ShowRoomUseCase(
    val addStockMotor: AddStockMotor,
    val getStockMotor: GetStockMotor,
    val getDetailMotor: GetDetailMotor,
    val getDetalMobil: GetDetalMobil,
    val updateStockMotor: UpdateStockMotor,
    val updateStockMobil: UpdateStockMobil,
    val addStockMobil: AddStockMobil,
    val getStockMobil: GetStockMobil
)