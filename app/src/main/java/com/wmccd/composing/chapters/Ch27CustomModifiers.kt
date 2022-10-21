package com.wmccd.composing.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmccd.composing.extensions.redball
import com.wmccd.composing.extensions.rotatingSquare

class Ch27CustomModifiers {

    @Composable
    fun Display() {

        Scaffold{
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    Modifier
                        .size(150.dp)
                        .redball()
                )

                Box(
                    Modifier
                        .size(150.dp)
                        .rotatingSquare(3000)
                        .background(Color.Red)
                )
            }

        }

    }

    @Composable
    @Preview
    fun Preview(){
        Display()
    }

}
