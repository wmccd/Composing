package com.wmccd.composing.chapters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

class Ch30Constraint {

    @Composable
    fun Display() {

        //ComposableButton()
        Column(
            Modifier.fillMaxWidth()
        ){
            BasicConstraints()
            Spacer(modifier = Modifier.height(10.dp))
            OpposingConstraints()
            Spacer(modifier = Modifier.height(10.dp))
            ConstraintBias()
        }


    }

    @Composable
    private fun ConstraintBias() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(border = BorderStroke(2.dp, Color.DarkGray))
                .clip(RoundedCornerShape(5.dp))
        ) {
            val (button) = createRefs()
            MyButton(
                words = "Constraint Bias",
                modifier = Modifier.constrainAs(button){
                    start.linkTo( anchor = parent.start, margin = 20.dp)
                    end.linkTo( anchor = parent.end)
                    linkTo(
                        top = parent.top,
                        bottom = parent.bottom,
                        bias = 0.75f
                    )
                }
            )
        }    }

    @Composable
    private fun OpposingConstraints() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(border = BorderStroke(2.dp, Color.DarkGray))
                .clip(RoundedCornerShape(5.dp))
        ) {
            val (button) = createRefs()
            MyButton(
                words = "Opposing Constraint",
                modifier = Modifier.constrainAs(button){
                    start.linkTo( anchor = parent.start, margin = 20.dp)
                    end.linkTo( anchor = parent.end)
                    linkTo(top = parent.top, bottom = parent.bottom)
                }
            )
        }
    }

    @Composable
    private fun BasicConstraints() {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(border = BorderStroke(2.dp, Color.DarkGray))
                .clip(RoundedCornerShape(5.dp))
        ) {
            val (button) = createRefs()
            MyButton(
                words = "Basic Constraint",
                modifier = Modifier.constrainAs(button){
                    top.linkTo( anchor = parent.top, margin = 60.dp)
                    start.linkTo( anchor = parent.start, margin = 20.dp)
                }
            )
        }
    }

    @Composable
    private fun ComposableButton() {
        MyButton(
            words  = "The Mighty Bobbins",
            modifier = Modifier.background(MaterialTheme.colors.primary)
        )
    }

    @Composable
    fun MyButton(words: String, modifier: Modifier = Modifier){
        Button(
            onClick = {},
            modifier = modifier
        ){
            Text(
                text = words
            )
        }
    }

    @Preview (showSystemUi = true)
    @Composable
    fun Preview(){
        Display()
    }

}
