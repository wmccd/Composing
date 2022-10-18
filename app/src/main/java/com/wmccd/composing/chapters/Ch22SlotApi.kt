package com.wmccd.composing.chapters

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wmccd.composing.ui.theme.ComposingTheme

class Ch22SlotApi {
     @Composable
     fun Display() {

         ComposingTheme {
             // A surface container using the 'background' color from the theme
             Surface(
                 modifier = Modifier.fillMaxSize(),
                 color = MaterialTheme.colors.background
             ) {
                Column{
                    NoSlot()
                    OneSlot(
                        middleSlot = { Text("Bobbins")}
                    )
                    AllSlot(
                        topSlot = { Text("The")},
                        middleSlot = { Text("Mighty")},
                        bottomSlot = { Text("Bobbins")}
                    )
                    AllSlot(
                        topSlot = { Text("The")},
                        middleSlot = {
                           Button(
                               onClick = {
                                   Log.d("XXX", "Clicked")
                                         },
                               content = {Text("Click")}
                           )
                         },
                        bottomSlot = { Text("Bobbins")}
                    )
                }
             }
         }
    }

    @Composable
    private fun NoSlot(){
        Text("Top")
        Text("Middle")
        Text("Bottom")
    }

    @Composable
    private fun OneSlot(middleSlot: @Composable ()->Unit){
        Text("Top")
        middleSlot()
        Text("Bottom")
    }

    @Composable
    private fun AllSlot(
        topSlot: @Composable ()->Unit,
        middleSlot: @Composable ()->Unit,
        bottomSlot: @Composable ()->Unit
    ){
        topSlot()
        middleSlot()
        bottomSlot()
    }

    @Preview
    @Composable
    fun Preview(){
        Display()
    }


}
