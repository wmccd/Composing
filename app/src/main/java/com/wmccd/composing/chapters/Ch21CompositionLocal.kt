package com.wmccd.composing.chapters

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wmccd.composing.ui.theme.ComposingTheme

class Ch21CompositionLocal {

    private val localColour = staticCompositionLocalOf { Color(0xFFffdbcf) }

    @Composable
    fun Display() {
        ComposingTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

                var colour = if(isSystemInDarkTheme()){
                    Color(0xFFff0000)
                }else{
                    Color(0xFF00ff00)
                }

                Column {
                    Display2()
                    CompositionLocalProvider(localColour provides colour) {
                        Display3()
                    }

                }
            }
        }
    }

    @Composable
    private fun Display2() {
        Display4()
    }

    @Composable
    private fun Display3() {
        Display5()
    }

    @Composable
    private fun Display4() {
        Display6()
    }

    @Composable
    private fun Display5() {
        Display7()
        Display8()
    }

    @Composable
    private fun Display6() {
        Text("Display 6",
            modifier = Modifier.background(localColour.current))
    }

    @Composable
    private fun Display7() {

    }

    @Composable
    private fun Display8() {
        Text(
            "Display 8",
            modifier = Modifier.background(localColour.current)
        )
    }

    @Composable
    @Preview(
        showBackground = true,
        uiMode = UI_MODE_NIGHT_YES
    )
    private fun DarkPreview(){
        Display()
    }

    @Composable
    @Preview(
        showBackground = true,
        uiMode = UI_MODE_NIGHT_NO,
    )
    private fun LightPreview(){
        Display()
    }

}
