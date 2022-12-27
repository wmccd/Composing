package com.wmccd.composing

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmccd.composing.chapters.*
import com.wmccd.composing.patterns.PatternRadioButtons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //PatternRadioButtons().Display()
            //Ch20StateAndRecomposition().Display()
            //Ch21CompositionLocal().Display()
            //Ch22SlotApi().Display()
            //Ch23SlotApi().Display()
            //Ch24Modifier().Display()
            //Ch25RowColumn().Display()
            //Ch26Box().Display()
            //Ch27CustomModifiers().Display()
            //Ch30Constraint().Display()
            //Ch31IntrinsicSize().Display()
            //Ch32ListsGrids().Display()
            //Ch34LazyList().Display()
            Ch36VisibilityAnimation().Display()
            Ch44Navigation().Display()

        }
    }

}



