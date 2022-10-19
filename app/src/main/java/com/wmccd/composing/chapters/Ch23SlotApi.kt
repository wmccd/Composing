package com.wmccd.composing.chapters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmccd.composing.R
import com.wmccd.composing.ui.theme.ComposingTheme

class Ch23SlotApi {
    @Composable
    fun Display() {
        ComposingTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Slots()
            }
        }
    }

    @Composable
    private fun Slots() {
        var linearSelected by remember {
            mutableStateOf(false)
        }

        var imageSelected by remember{
            mutableStateOf(true)
        }

        val onLinerClick = { value: Boolean ->
            linearSelected = value
        }

        val onImageClick = { value: Boolean ->
            imageSelected = value
        }

        ScreenContent(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onTitleClick = onImageClick,
            onLinearClick = onLinerClick,
            titleContent = {
               when(imageSelected){
                   true -> TitleImage(
                       drawing = R.drawable.ic_baseline_cloud_download_24
                   )
                   false -> Text(
                       text = "Downloading",
                       style = MaterialTheme.typography.h3,
                       modifier = Modifier.padding(30.dp)
                   )
               }
            },
            progressContent = {
                when(linearSelected){
                    true -> LinearProgressIndicator(
                        modifier = Modifier.padding(30.dp)
                    )
                    false -> CircularProgressIndicator(
                        modifier = Modifier.padding(200.dp),
                        strokeWidth = 18.dp,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        )
    }



    @Composable
    private fun ScreenContent(
        linearSelected: Boolean,
        imageSelected: Boolean,
        onTitleClick: (Boolean) -> Unit,
        onLinearClick: (Boolean) -> Unit,
        titleContent: @Composable () -> Unit,
        progressContent: @Composable () -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){

            titleContent()
            progressContent()
            CheckBoxes(
                linearSelected =linearSelected ,
                imageSelected = imageSelected,
                onTitleClick = onTitleClick,
                onLinearClick = onLinearClick
            )
        }

    }

    @Composable
    private fun CheckBoxes(
        linearSelected: Boolean,
        imageSelected: Boolean,
        onTitleClick: (Boolean) -> Unit,
        onLinearClick: (Boolean) -> Unit
    ){
       Row(
           modifier = Modifier.padding(20.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ){
           Checkbox(checked = imageSelected , onCheckedChange = onTitleClick)
           Text("Image Title")
           Spacer(Modifier.width(20.dp))
           Checkbox(checked = linearSelected , onCheckedChange = onLinearClick)
           Text("Linear Progress")
       }
    }

    @Composable
    private fun TitleImage(drawing: Int){
        Image(
            painter = painterResource(id = drawing),
            contentDescription = "Title Image"
        )
    }

    @Preview (showSystemUi = true)
    @Composable
    private fun Preview(){
        Display()
    }
}
