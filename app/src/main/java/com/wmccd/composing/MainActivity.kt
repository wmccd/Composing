package com.wmccd.composing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wmccd.composing.chapters.Ch20StateAndRecomposition
import com.wmccd.composing.chapters.Ch21CompositionLocal
import com.wmccd.composing.chapters.Ch22SlotApi
import com.wmccd.composing.ui.theme.ComposingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Ch20StateAndRecomposition().Display()
            //Ch21CompositionLocal().Display()
            Ch22SlotApi().Display()
        }
    }


}

