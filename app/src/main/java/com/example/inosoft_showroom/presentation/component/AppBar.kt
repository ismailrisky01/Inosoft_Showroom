package com.example.inosoft_showroom.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inosoft_showroom.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appbar(modifier: Modifier = Modifier,title: String="", onNavIconPressed: () -> Unit = { }, page: String = Screen.MainScreen.route) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },

        navigationIcon = {

            Icon(
                imageVector =if (page == Screen.MainScreen.route) {
                    Icons.Rounded.Menu
                } else {
                    Icons.Rounded.ArrowBack
                },
                contentDescription = "null",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .size(30.dp)
                    .clickable(onClick = onNavIconPressed)
            )


        }
    )
}