package com.wmccd.composing.chapters

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Ch24Modifier {
    @Composable
    fun Display() {
        val modifier = Modifier
            .padding(all = 10.dp)
            .border(width = 2.dp, color = Color.Red)


        Text(
            modifier = modifier,
            text = "The Mighty Bobbins",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }

    @Preview (showBackground = true)
    @Composable
    private fun Preview(){
        Display()
    }
}
