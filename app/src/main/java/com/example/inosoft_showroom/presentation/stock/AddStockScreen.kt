package com.example.inosoft_showroom.presentation.stock

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inosoft_showroom.data.model.Motor
import com.example.inosoft_showroom.presentation.component.Appbar
import com.example.inosoft_showroom.presentation.util.Screen
import org.koin.androidx.compose.getViewModel
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStockScreen(navController: NavController? = null,onSubmit:(Motor)->Unit){
    val viewModel: StockViewModel = getViewModel<StockViewModel>()
val context = LocalContext.current
    var name by rememberSaveable { mutableStateOf("") }
    var warna by rememberSaveable { mutableStateOf("") }
    var tahunKeluaran by rememberSaveable { mutableStateOf("") }
    var harga by rememberSaveable { mutableStateOf(0.0) }
    var mesin by rememberSaveable { mutableStateOf("") }
    var tipeSuspensi by rememberSaveable { mutableStateOf("") }
    var tipeTransmisi by rememberSaveable { mutableStateOf("") }

    fun validate():Boolean{
        if (name.isEmpty()) return false
        if (warna.isEmpty()) return false
        if (tahunKeluaran.isEmpty()) return false
        if (harga == 0.0) return false
        if (mesin.isEmpty()) return false
        if (tipeSuspensi.isEmpty()) return false
        if (tahunKeluaran.isEmpty()) return false
        return true
    }
    fun reset(){
        name=""
        warna=""
        tahunKeluaran=""
        mesin=""
        tipeSuspensi=""
        tahunKeluaran=""
        harga=0.0
    }
    Scaffold(  topBar = {
        Appbar(title = "Tambah Stock", onNavIconPressed = {
            navController?.popBackStack()
        }, page = Screen.StockKendaraanScreen.route)
    },) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(
                        text = "Nama Kendaraan"
                    )
                },
            )
            OutlinedTextField(
                value = warna,
                onValueChange = { warna = it },
                label = {
                    Text(
                        text = "Warna Kendaraan"
                    )
                },
            )
            OutlinedTextField(
                value = tahunKeluaran,
                onValueChange = { tahunKeluaran = it },
                label = {
                    Text(
                        text = "Tahun Keluaran Kendaraan"
                    )
                },
            )
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = harga.toString(),
                onValueChange = { harga = it.toDouble() },
                label = {
                    Text(
                        text = "Harga Kendaraan"
                    )
                },
            )
            OutlinedTextField(
                value = mesin,
                onValueChange = { mesin = it },
                label = {
                    Text(
                        text = "Mesin Kendaraan"
                    )
                },
            )
            OutlinedTextField(
                value = tipeSuspensi,
                onValueChange = { tipeSuspensi = it },
                label = {
                    Text(
                        text = "Tipe Suspensi Kendaraan"
                    )
                },
            )
            OutlinedTextField(
                value = tipeTransmisi,
                onValueChange = { tipeTransmisi = it },
                label = {
                    Text(
                        text = "Tipe Transmisi Kendaraan"
                    )
                },
            )
            Button(
                contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                onClick = {
                    if (validate()){
                        viewModel.addDataListMotor(Motor(tahunKeluaran = tahunKeluaran, warna = warna, harga = harga, nama = name,mesin =mesin, tipeSuspensi =  tipeSuspensi, tipeTransmisi= tipeTransmisi))
                        reset()
                        navController!!.popBackStack()
                    }else{
                        Toast.makeText(context, "Lengkapi data", Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Text(text = "Submit", color = Color.White)
            }
        }

    }
}