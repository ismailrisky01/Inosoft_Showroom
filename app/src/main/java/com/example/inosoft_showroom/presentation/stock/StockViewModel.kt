package com.example.inosoft_showroom.presentation.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    fun getDataListMotor(){
        viewModelScope.launch {
            showRoomUseCase.getStockMotor.invoke().collect{result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        myLog("Success Get List Motor ${result.data?.size}")
                        _listMotor.value = result.data!!

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
            showRoomUseCase.getStockMotor.invoke().collect{result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        myLog("Success Get List Motor ${result.data?.size}")
                        _listMotor.value = result.data!!

                    }

                    Status.ERROR -> {



                    }

                    Status.LOADING -> {}
                }

            }
        }
    }
}