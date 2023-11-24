package com.example.inosoft_showroom.domain.feature

import coil.network.HttpException
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.domain.repository.Repository
import com.ismaildev.rawg_perqara.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetDetailMotor(private val repository: Repository) {
    suspend operator fun invoke(id:Int): Flow<Resource<List<Motor>>> = flow {
        try {
            emit(Resource.success(repository.getStockKendaraanMotor()))
        }catch(e: HttpException) {
            emit(Resource.error(e.localizedMessage ?: "An unexpected error occured",null))
        } catch(e: IOException) {
            emit(Resource.error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.",null))

        }}
}