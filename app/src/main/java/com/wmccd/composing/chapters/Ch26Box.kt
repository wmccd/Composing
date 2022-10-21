package com.wmccd.composing.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Ch26Box {

    @Composable
    fun Display() {

        Column() {
            StackedCells()
            Text("jjghjgj")
            Alignments()
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CutCornerShape(30.dp))
                    .background(Color.Blue)
            )


        }

    }



    @Composable
    private fun Alignments() {


            Box(
                modifier = Modifier
                    .size(
                    width = 400.dp,
                    height = 200.dp
                )
                    .background(Color.Red)
            ) {
                Text(
                    text = "TopStart",
                    modifier = Modifier.align(Alignment.TopStart),
                )
                Text(
                    text = "TopCenter",
                    modifier = Modifier.align(Alignment.TopCenter),
                )
                Text(
                    text = "BottomCenter",
                    modifier = Modifier.align(Alignment.BottomCenter),
                )
                Text(
                    text = "BottomRight",
                    modifier = Modifier.align(Alignment.BottomEnd),
                )
                Text(
                    text = "Center",
                    modifier = Modifier.align(Alignment.Center),
                )
            }

    }

    @Composable
    private fun StackedCells() {
        val height = 200.dp
        val width = 200.dp
        val modifier = Modifier
            .height(height)
            .width(width)


        Box {
            TextCell(
                words = "1",
                modifier = modifier,
            )

            TextCell(
                words = "2",
                modifier = modifier,
            )

            TextCell(
                words = "3",
                modifier = modifier,
            )
        }
    }


    @Composable
    private fun TextCell(
        words: String,
        modifier: Modifier = Modifier,
        fontSize: Int = 150
    ){

        val cellModifier = Modifier
            .padding(4.dp)
            .border(
                width = 5.dp,
                color = Color.Black
            )

        //without surface it
        Surface {
            Text(
                text = words,
                modifier = cellModifier.then(modifier),
                fontSize = fontSize.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

    }

    @Composable
    @Preview
    private fun Preview(){
        Display()
    }

}
