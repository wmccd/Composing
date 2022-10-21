package com.wmccd.composing.patterns

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmccd.composing.chapters.Ch20StateAndRecomposition
import com.wmccd.composing.chapters.Ch21CompositionLocal
import com.wmccd.composing.chapters.Ch22SlotApi

class PatternRadioButtons {

    @Composable
    fun Display(){
        val radioOptions = listOf("A", "B", "C")
        var selected by remember{ mutableStateOf("") }
        val modifier = Modifier.background(MaterialTheme.colors.primary)

        RadioOptions(
            options = radioOptions,
            selected = selected,
            onSelected = {
                selected = it
                Log.d("XXX", "Selected $selected")
            },
            modifier = modifier
        )

        when(selected){
            "A", "B", "C" -> {
                Log.d("XXX", "Doing Something After Selecting: $selected")
            }
            else -> {}
        }
    }

    @Composable
    private fun RadioOptions(
        options: List<String>,
        selected: String,
        onSelected: (String) -> Unit,
        modifier: Modifier = Modifier
    ){
        Column {
            options.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selected),
                            onClick = { onSelected(text) }
                        )
                        .padding(horizontal = 16.dp)
                        .then(modifier)
                ) {
                    RadioButton(
                        selected = (text == selected),
                        onClick = {onSelected(text)}
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }

    @Composable
    @Preview
    private fun Preview(){
        Display()
    }
}