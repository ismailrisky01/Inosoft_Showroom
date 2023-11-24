package com.example.inosoft_showroom.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inosoft_showroom.R
import com.example.inosoft_showroom.ui.theme.Blue

@Composable
fun DisplayCard(
    title: String,
    image: Int,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.padding(8.dp).width(IntrinsicSize.Max),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(backgroundColor),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Image(
            modifier = Modifier
                .size(170.dp).padding(30.dp)
                .align(Alignment.End),
            painter = painterResource(id = image),
            contentDescription = title)
    }
}

@Preview
@Composable
fun DisplayCardPreview() {
    DisplayCard(
        "Notes",
        R.drawable.notes_img,
        Blue
    )
}