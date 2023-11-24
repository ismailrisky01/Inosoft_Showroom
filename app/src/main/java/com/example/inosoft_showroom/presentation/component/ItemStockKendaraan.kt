package com.example.inosoft_showroom.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.inosoft_showroom.data.model.Motor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemStockMotor(motor: Motor ,onPressed: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .fillMaxSize().padding(10.dp)
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp) // Adjust the radius to control the roundness
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable { onPressed.invoke() }) {
            Text(text ="Nama Kendaraan ${motor.nama}")
            Text(text ="Harga = ${motor.harga}")
            Text(text ="Mesin = ${motor.mesin}")
        }
    }

}