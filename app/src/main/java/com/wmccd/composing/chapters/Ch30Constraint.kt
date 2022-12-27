package com.wmccd.composing.chapters

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

class Ch30Constraint {

    @Composable
    fun Display() {

        //ComposableButton()
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())

        ){

            Barrier()
            Divider()
            BasicConstraints()
            Divider()
            OpposingConstraints()
            Divider()
            ConstraintBias()
            Divider()

            Chains(chainStyle = ChainStyle.Spread)
            Chains(chainStyle = ChainStyle.SpreadInside)
            Chains(chainStyle = ChainStyle.Packed)
            Spacer(modifier = Modifier.height(150.dp))



        }


    }

    @Composable
    private fun Barrier() {
        ConstraintLayout(
            modifier = Modifier
                .height(220.dp)
                .width(350.dp)
        ) {

            //button 3 start is constrained to end of button 1
            //button 3 start is not constrained to end of button 2

            val (button1, button2, button3) = createRefs()
            val barrier = createEndBarrier(button1, button2)

            MyButton(
                words = "Button1",
                modifier = Modifier
                    .width(100.dp)
                    .constrainAs(button1){
                        top.linkTo(anchor = parent.top, margin = 30.dp)
                        start.linkTo(anchor = parent.start, margin = 30.dp)
                    }
            )

            MyButton(
                words = "Button2",
                modifier = Modifier
                    .background(MaterialTheme.colors.secondary)
                    .width(250.dp)
                    .constrainAs(button2){
                        top.linkTo(anchor = button1.bottom, margin = 20.dp)
                        start.linkTo(anchor = parent.start, margin = 8.dp)
                    }
            )

            MyButton(
                words = "Button3",
                modifier = Modifier
                    .width(100.dp)
                    .constrainAs(button3
                    ){
                        linkTo(
                            top = parent.top, bottom = parent.bottom,
                            topMargin = 8.dp, bottomMargin = 8.dp
                        )
                        linkTo(start = button1.end, end = parent.end,
                            startMargin = 30.dp, endMargin = 8.dp
                        )
                        start.linkTo(barrier, margin = 30.dp)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )
        }
    }

    @Composable
    private fun Chains( chainStyle: ChainStyle) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .border(border = BorderStroke(2.dp, Color.DarkGray))
                .clip(RoundedCornerShape(5.dp))
        ) {

            val (button1, button2, button3) = createRefs()
            createHorizontalChain(
                button1, button2, button3,
                chainStyle =  chainStyle
            )

            MyButton(
                words = "B1",
                modifier = Modifier.constrainAs(button1){
                    centerVerticallyTo(parent)
                }
            )
            MyButton(
                words = "B2",
                modifier = Modifier.constrainAs(button2){
                    centerVerticallyTo(parent)
                }
            )
            MyButton(
                words = "B3",
                modifier = Modifier.constrainAs(button3){
                    centerVerticallyTo(parent)
                }
            )
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
        }
    }

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
