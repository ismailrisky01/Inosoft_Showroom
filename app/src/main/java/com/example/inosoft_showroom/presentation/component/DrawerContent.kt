package com.example.inosoft_showroom.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.inosoft_showroom.presentation.util.Screen


@Composable
fun DrawerContent(
    onDestinationClicked: (route: String) -> Unit
) {
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        DrawerHead()
        DividerItem()
        DrawerItem(text = "Stok Kendaraan", selected = false, onChatClicked = {onDestinationClicked(Screen.StockKendaraanScreen.route) }, iconImage =  Icons.Filled.Add)
        DrawerItem(text = "Penjualan Kendaraan", selected = false, onChatClicked = { }, iconImage =  Icons.Filled.Refresh)
        DrawerItem(text = "Laporan Penjualan per Kendaraan", selected = false, onChatClicked = { }, iconImage =  Icons.Filled.Refresh)



    }


}
@Composable
fun DividerItem(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
}
@Composable
fun DrawerHead() {
   Text(text = "PT. Inosoft Trans Sistem", modifier = Modifier.padding(10.dp))
}
@Composable
private fun DrawerItem(text: String, selected: Boolean, onChatClicked: () -> Unit,iconImage: ImageVector) {
    val background = if (selected) {
        Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    } else {
        Modifier
    }
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clip(CircleShape)
            .then(background)
            .clickable(onClick = onChatClicked),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconTint = if (selected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
        Icon(
            imageVector = iconImage,
            tint = iconTint,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            contentDescription = null
        )
        Text(
            text,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            },
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}