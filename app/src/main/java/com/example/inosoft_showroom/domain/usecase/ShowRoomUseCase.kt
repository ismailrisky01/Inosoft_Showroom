package com.example.inosoft_showroom.domain.usecase

import com.example.inosoft_showroom.domain.feature.AddStockMotor
import com.example.inosoft_showroom.domain.feature.GetDetailMotor
import com.example.inosoft_showroom.domain.feature.GetStockMotor

data class ShowRoomUseCase (val addStockMotor: AddStockMotor, val getStockMotor: GetStockMotor,val getDetailMotor:GetDetailMotor)