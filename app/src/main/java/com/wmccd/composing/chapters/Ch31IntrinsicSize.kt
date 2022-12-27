package com.wmccd.composing.chapters

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Ch31IntrinsicSize {

    @Composable
    fun Display() {

        var wordState by remember{mutableStateOf("")}

        val onChange = { words: String ->
            Log.d("XXX", "$words")
            wordState = words
        }

        Column(
            modifier = Modifier
                .width(200.dp)
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Min)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = wordState
                )

                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                ){
                    MyTextField(
                        words = wordState,
                        onChange = onChange
                    )
                }
            }

        }

//        Surface(modifier = Modifier.background(Color.Red)){
//            Row(modifier = Modifier.background( Color.Green)){
//                Text(text = "Hello", modifier = Modifier.background( Color.Blue))
//                Text(text = "Hello",
//                    modifier = Modifier
//                        .background(Color.Magenta)
//                        .padding(10.dp)
//                )
//            }
//        }
    }


    @Composable
    private fun MyTextField( words: String, onChange: (String)->Unit ){
        TextField(
            value = words,
            onValueChange = onChange
        )
    }

    @Composable
    @Preview
    private fun Preview(){
        Display()
    }

}
