package com.wmccd.composing.chapters

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wmccd.composing.MyApplication
import com.wmccd.composing.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Ch34LazyList {

    @Composable
    fun Display() {
        val itemArray = MyApplication.appContext.resources.getStringArray(R.array.car_array)

        Cars(
            itemArray = itemArray,
            onClick = ::handleCarClick
        )
    }

    private fun handleCarClick(clickedItem: String){
        Log.d("XXX", "Clicked XXX $clickedItem")
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    private fun Cars( itemArray: Array<String>, onClick: (String)->Unit) {

        val initialGroups = itemArray.groupBy { it.first() }
        val coroutineScope = rememberCoroutineScope()
        val lazyListState = rememberLazyListState()
        val displayGoToTopButton = lazyListState.firstVisibleItemIndex > 3

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box {
                LazyColumn(
                    contentPadding = PaddingValues(8.dp),
                    state = lazyListState
                ) {

                    initialGroups.forEach { firstLetter, group ->
                        stickyHeader {

                            Text(
                                text = firstLetter.toString(),
                                color = Color.White,
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .padding(40.dp)
                                    .fillMaxWidth()
                            )
                        }


                        items(
                            group
                        ) { item ->
                            MyListItem(
                                name = item,
                                onClicked = {
                                    onClick(it)
                                }
                            )
                        }
                    }
                }

                AnimatedVisibility(
                    visible = displayGoToTopButton,
                    modifier = Modifier.align(Alignment.BottomCenter)

                ) {
                    GoToTopButton(coroutineScope, lazyListState)
                }

            }
        }
    }

    @Composable
    private fun GoToTopButton(
        coroutineScope: CoroutineScope,
        lazyListState: LazyListState
    ) {
        OutlinedButton(
            onClick = {
                coroutineScope.launch {
                    lazyListState.animateScrollToItem(0)
                }
            },
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.DarkGray
            ),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "Top")
        }
    }

    @Composable
    private fun MyListItem(name: String, onClicked: (String)->Unit){

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .clickable { onClicked(name) },
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                ImageLoader(name = name)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )

            }
        }

    }

    @Composable
    fun ImageLoader(name: String){

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_directions_car_24),
            contentDescription = "$name image"
        )
    }

    @Preview
    @Composable
    fun Preview(){
        val itemArray = arrayOf("Alpine ", "Alpha Tauri", "Alpha Romeo", "Ferrari", "Haas", "McLaren", "Mercedes", "Red Bull", "Williams"  )
        Cars(
            itemArray,
            {}
        )
    }

}
