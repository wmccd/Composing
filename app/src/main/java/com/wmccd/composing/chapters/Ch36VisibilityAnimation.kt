package com.wmccd.composing.chapters

import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class Ch36VisibilityAnimation {

    @Composable
    fun Display() {

    }

    @Composable
    private fun CustomButton(
        text: String,
        targetState: Boolean,
        onClick: (Boolean)->Unit,
        backgroundColour: Color = Color.Blue
    ){
        Button(
            onClick = {onClick(targetState)},
            modifier = Modifier.background(color = backgroundColour),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = backgroundColour,
                contentColor = Color.White
            )
        ) {
            Text(text = text)
        }

    }

    @Composable
    @Preview(showBackground = true, showSystemUi = true)
    fun Preview(){
        Display()
    }

}
