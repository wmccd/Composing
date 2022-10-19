package com.wmccd.composing.chapters

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wmccd.composing.R
import com.wmccd.composing.ui.theme.ComposingTheme

class Ch24Modifier {
    @Composable
    fun Display() {

        val paddingBorderModifier = Modifier
            .padding(all = 10.dp)
            .border(width = 2.dp, color = Color.Red)

        val borderPaddingModifier = Modifier
            .border(width = 2.dp, color = Color.Red)
            .padding(all = 10.dp)

        val roundedModifier = Modifier
            .background(Color.Green)
            .padding(16.dp)
            .width(180.dp)
            .clip(shape = RoundedCornerShape(30.dp))

        val cutModifier = Modifier
            .padding(16.dp)
            .width(180.dp)
            .clip(shape = AbsoluteCutCornerShape(30.dp))

        val roundOnlyModifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
        val sizeOnlyModifier = Modifier
            .size(180.dp)
        val borderOnlyModifier = Modifier
            .border(width = 2.dp, color = Color.Green)

        val words = "The Mighty Bobbins"

        ComposingTheme {
            // A surface container using the 'background' color from the theme
            androidx.compose.material.Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ){
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState())
                ){
                    DisplayText(
                        words = words,
                        modifier = borderPaddingModifier
                    )
                    DisplayText(
                        words = words,
                        modifier = paddingBorderModifier
                    )
                    DisplayImage(
                        id = R.drawable.coast1,
                        modifier = borderPaddingModifier
                    )
                    DisplayImage(
                        id = R.drawable.coast1,
                        modifier = paddingBorderModifier
                    )
                    DisplayImage(
                        id = R.drawable.coast1,
                        modifier = roundedModifier
                    )
                    DisplayImage(
                        id = R.drawable.coast1,
                        modifier = cutModifier
                    )
                    DisplayImage(
                        id = R.drawable.coast1,
                        modifier = sizeOnlyModifier
                            .then(borderOnlyModifier)
                            .then(roundOnlyModifier)
                    )
                }

            }
        }
    }

    @Composable
    private fun DisplayText(words: String, modifier: Modifier = Modifier){
        Text(
            text = words,
            modifier = modifier
        )
    }

    @Composable
    private fun DisplayImage(id: Int, modifier: Modifier){
        Image(
            painter = painterResource(id = id),
            contentDescription = "Image",
            modifier = modifier
        )
    }

    @Preview (showBackground = true)
    @Composable
    private fun Preview(){
        Display()
    }
}
