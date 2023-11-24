package com.example.inosoft_showroom.domain.feature

import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.domain.repository.Repository

class AddStockMotor(private val repository: Repository) {
    suspend operator fun invoke(motor: Motor) {
        repository.addStockMotor(motor)
    }
}