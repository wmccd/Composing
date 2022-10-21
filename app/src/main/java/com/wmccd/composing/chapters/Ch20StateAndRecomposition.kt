package com.wmccd.composing.chapters

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmccd.composing.ui.theme.ComposingTheme

class Ch20StateAndRecomposition {

    @Composable
    fun Display() {

        BackHandler(enabled = true){
            // execute your custome logic here
        }

        ComposingTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column{
                    Text("UI Elements that maintain internal state: BAD")
                    Row{
                        Text(text = "Remember with value")
                        MyTextFieldValue()
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row{
                        Text(text = "Remember with by")
                        MyTextFieldBy()
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Text("UI Elements that hoist their state: GOOD" +
                            "")
                    Row{
                        Text(text = "Unidirectional Flow\nactions go out\ndata comes in ")
                        Switcher()
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row{
                        Text(text = "Unidirectional Flow\nactions go out\ndata comes in ")
                        Texter()
                    }
                }

            }
        }
    }

    @Composable
    private fun Switcher() {
        var switchState by remember {
            mutableStateOf(false)
        }

        val onSwitchStateChange = { value: Boolean ->
            switchState = value
        }

        DisplaySwitcher(switchState, onSwitchStateChange)
    }

    @Composable
    private fun DisplaySwitcher(switchState: Boolean, onChange: (Boolean) -> Unit){
        Switch(
            checked = switchState,
            onCheckedChange = onChange
        )
    }

    @Composable
    private fun Texter(){

        var textState by remember{mutableStateOf("")}

        val onTextChanged = { updatedText: String ->
            textState = updatedText
        }

        DisplayText(
            state = textState,
            onTextChanged = onTextChanged
        )
    }

    @Composable
    private fun DisplayText(state: String, onTextChanged:(String) -> Unit) {
        TextField(
            value = state,
            onValueChange = onTextChanged
        )
    }


    @Composable
    private fun MyTextFieldValue(){
        var textState = remember{ mutableStateOf("") }

        val onTextChange = { text: String ->
            Log.d("XXX", "Value $text")
            textState.value = text
        }

        TextField(
            value = textState.value,
            onValueChange = onTextChange)
    }


    @Composable
    fun MyTextFieldBy(){
        var textState by remember{ mutableStateOf("") }

        val onTextChange = { text: String ->
            Log.d("XXX", "By $text")
            textState = text
        }

        TextField(
            value = textState,
            onValueChange = onTextChange)
    }

    @Preview(showBackground = true)
    @Composable
    private fun DefaultPreview() {
        Display()
    }
}