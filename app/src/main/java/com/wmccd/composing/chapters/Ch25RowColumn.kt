package com.wmccd.composing.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wmccd.composing.ui.theme.ComposingTheme

class Ch25RowColumn {


    @Composable
    fun Display() {
        ComposingTheme() {
            Scaffold() {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ){
                    TextCellsInAColumn()
                    Divider()
                    TextCellsInARow()
                    Divider()
                    TextCellsInAGrid()
                    Divider()
                    TextCellAlignmentAndArrangement1()
                    Divider()
                    TextCellAlignmentAndArrangement2()
                    Divider()
                    TextCellAlignmentAndArrangement3()
                    Divider()
                    TextCellAlignmentAndArrangement4()
                    Divider()
                    TextCellRowScope()
                    Divider()
                    TextCellRowWeight()
                    Divider()
                }
            }
        }
    }

    private @Composable
    fun TextCellRowWeight() {
        Row(
            modifier = Modifier
                .width(width = 150.dp)
                .background(color = Color.Magenta),

        ){
            TextCell(words = "1",
                Modifier.weight( weight = 0.2f)
            )
            TextCell(words = "2",
                Modifier.weight( weight = 0.3f)
            )
            TextCell(words = "3",
                Modifier.weight( weight = 0.5f)
            )
        }
    }

    @Composable
    private fun TextCellRowScope() {
        Row(
            modifier = Modifier
                .size(
                    height = 60.dp,
                    width = 150.dp
                )
                .background(Color.Green),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ){
            TextCell(words = "1",
                Modifier.background(Color.Red)
            )
            TextCell(words = "2",
                Modifier.background(Color.Yellow)
            )
            TextCell(words = "3",
                Modifier.background(Color.Cyan)
            )
        }
    }

    @Composable
    private fun TextCellAlignmentAndArrangement4() {
        Row(
            modifier = Modifier
                .size(
                    height = 60.dp,
                    width = 150.dp
                )
                .background(Color.Blue),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column(
                modifier = Modifier.height(height = 60.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ){
                TextCell(words = "1")
            }
            Column(
                modifier = Modifier.height(height = 60.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ){
                TextCell(words = "2")
            }
            Column(
                modifier = Modifier.height(height = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                TextCell(words = "3")
            }
        }

    }

    @Composable
    private fun TextCellAlignmentAndArrangement1() {
        Row(
            modifier = Modifier
                .size(
                    height = 60.dp,
                    width = 150.dp
                )
                .background(Color.Green),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ){
            TextCell(words = "1")
            TextCell(words = "2")
            TextCell(words = "3")
        }
    }

    @Composable
    private fun TextCellAlignmentAndArrangement2() {
        Row(
            modifier = Modifier
                .size(
                    height = 60.dp,
                    width = 150.dp
                )
                .background(Color.Red),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextCell(words = "1")
            TextCell(words = "2")
            TextCell(words = "3")
        }
    }

    @Composable
    private fun TextCellAlignmentAndArrangement3() {
        Row(
            modifier = Modifier
                .size(
                    height = 60.dp,
                    width = 150.dp
                )
                .background(Color.Yellow),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            TextCell(words = "1")
            TextCell(words = "2")
            TextCell(words = "3")
        }
    }

    @Composable
    private fun TextCellsInAGrid() {
        Column(modifier =Modifier.background(Color.LightGray)) {
            Row() {
                TextCell(words = "1")
                TextCell(words = "2")
                TextCell(words = "3")
            }
            Row() {
                TextCell(words = "4")
                TextCell(words = "5")
                //TextCell(words = "6")
            }
            Row() {
                TextCell(words = "7")
                TextCell(words = "8")
                TextCell(words = "9")
            }
        }
    }

    private @Composable
    fun TextCellsInARow() {
        Row() {
            TextCell(words = "1")
            TextCell(words = "2")
            TextCell(words = "3")
        }
    }

    @Composable
    private fun TextCellsInAColumn() {
        Column() {
            TextCell(words = "1")
            TextCell(words = "2")
            TextCell(words = "3")
        }
    }


    @Composable
    private fun TextCell(words: String, modifier: Modifier = Modifier){

        val cellModifier = Modifier
            .padding(4.dp)
            .size(
                width = 20.dp,
                height = 20.dp
            )
            .border(
                width = 4.dp,
                color = Color.Black
            )

        Text(
            text = words,
            modifier = cellModifier.then(modifier),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    @Preview
    @Composable
    private fun Preview(){
        Display()
    }

}
