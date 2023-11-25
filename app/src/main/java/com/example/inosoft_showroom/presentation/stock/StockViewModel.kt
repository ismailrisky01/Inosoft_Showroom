package com.example.inosoft_showroom.presentation.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inosoft_showroom.data.model.Mobil
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.domain.usecase.ShowRoomUseCase
import com.example.inosoft_showroom.presentation.util.myLog
import com.ismaildev.rawg_perqara.util.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StockViewModel(private val showRoomUseCase: ShowRoomUseCase):ViewModel() {
//    private val _listMotor = MutableStateFlow<List<Motor>>(emptyList())
//    val listMotor get() = _listMotor
    private val _listMotor = MutableLiveData<List<Motor>>(emptyList())
    val listMotor: LiveData<List<Motor>> = _listMotor

    private val _listMobil = MutableLiveData<List<Mobil>>(emptyList())
    val listMobil: LiveData<List<Mobil>> = _listMobil

    private val _dataMotor = MutableLiveData<Motor>()
    val dataMotor: LiveData<Motor> = _dataMotor
    private val _dataMobil = MutableLiveData<Mobil>()
    val dataMobil: LiveData<Mobil> = _dataMobil
    private val _nama = MutableStateFlow<String>("" )
    val nama get() = _nama

init {

    getDataListMotor()
}
    fun addDataListMotor(motor: Motor){
        viewModelScope.launch {
            showRoomUseCase.addStockMotor.invoke(motor)
        }
    }
    fun addDataListMobil(mobil: Mobil){
        viewModelScope.launch {
            showRoomUseCase.addStockMobil.invoke(mobil)
        }
    }
    fun getDataListMotor(isSold:Boolean?=false){
        viewModelScope.launch {
            showRoomUseCase.getStockMotor.invoke().collect{result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        myLog("Success Get List Motor ${result.data?.size}")
                        val newList = result.data!!.filter { it.isSold==isSold }
                        _listMotor.value = newList

                    }

                    Status.ERROR -> {



                    }

                    Status.LOADING -> {}
                }

            }
        }
    }
    fun getDataListMobil(isSold:Boolean?=false){
        viewModelScope.launch {
            showRoomUseCase.getStockMobil.invoke().collect{result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        myLog("Success Get List Motor ${result.data?.size}")
                        val newList = result.data!!.filter { it.isSold==isSold }
                        _listMobil.value = newList

                    }

                    Status.ERROR -> {



                    }

                    Status.LOADING -> {}
                }

            }
        }
    }
    fun getDataMotor(id:Int){
        viewModelScope.launch {
            showRoomUseCase.getDetailMotor.invoke(id).collect{result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        myLog("Success Get List Motor ")
                        _dataMotor.value = result.data!!

                    }

                    Status.ERROR -> {



                    }

                    Status.LOADING -> {}
                }

            }
        }
    }
    fun getDataMobil(id:Int){
        viewModelScope.launch {
            showRoomUseCase.getDetalMobil.invoke(id).collect{result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        myLog("Success Get List Motor ")
                        _dataMobil.value = result.data!!

                    }

                    Status.ERROR -> {



                    }

                    Status.LOADING -> {}
                }

            }
        }
    }
    fun jualMotor(id:Int){
        viewModelScope.launch {
            showRoomUseCase.updateStockMotor.invoke(id,true)

        }
    }
    fun jualMobil(id:Int){
        viewModelScope.launch {
            showRoomUseCase.updateStockMobil.invoke(id,true)

        }
    }
}