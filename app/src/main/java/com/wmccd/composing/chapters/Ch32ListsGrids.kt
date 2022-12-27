package com.wmccd.composing.chapters

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class Ch32ListsGrids {

    @Composable
    fun Display() {

        Scaffold() {
            // ScrollableRow()
            // ScrollableColumn()
            // AddingLazyItems()
            // ColumnProgrammaticScrolling()
            // LazyColumnProgrammaticScrolling()
            // StickyHeaders()
             LazyGrid()
        }

    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    private fun LazyGrid() {

        Column(modifier = Modifier.fillMaxWidth()) {

            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 103.dp),
                state = rememberLazyListState(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(count = 20) { index ->
                    Card(
                        backgroundColor = Color.Blue,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = "$index",
                            fontSize = 35.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            LazyVerticalGrid(
                cells = GridCells.Fixed(count = 5),
                state = rememberLazyListState(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(count = 30) { index ->
                    Card(
                        backgroundColor = Color.Green,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = "$index",
                            fontSize = 35.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    private fun StickyHeaders() {
        val phones = listOf(
            "Apple iPhone 12", "Apple iPhone 13", "Apple iPhone 14",
            "Google Pixel 2", "Google Pixel 3", "Google Pixel 4",
            "Samsung Galaxy 1", "Samsung Galaxy 2", "Samsung Galaxy 3",
            "Apple iPhone 15", "Apple iPhone 16", "Apple iPhone 17",
            "Google Pixel 5", "Google Pixel 6", "Google Pixel 7",
            "Samsung Note 1", "Samsung Note 2", "Samsung Note 3",
        )

        val groupedPhones = phones.groupBy {
            it.substringBefore(" ")
        }

        LazyColumn{
            groupedPhones.forEach { (manufacturer, models) ->

                stickyHeader {
                    Text(
                        text = manufacturer,
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(50.dp)
                            .fillMaxWidth()
                    )
                }

                items(models){ model ->
                    Text( text = model,
                    modifier = Modifier.padding(50.dp))
                }
            }
        }


    }

    @Composable
    private fun ColumnProgrammaticScrolling() {

        val coroutineScope = rememberCoroutineScope()

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth(),
        ){

            Button(
                onClick = {
                    //the scrolling has to be done in a coroutineScope
                    coroutineScope.launch {
                        //you scroll to a pixel(?!??) rather than an index in the list.
                        //luckily you can scroll to the bottom as below.
                        scrollState.animateScrollTo(value = scrollState.maxValue)
                    }
                }
            ){
                Text("Push me")
            }

            repeat(100){
                Text(text = "Bobbins #$it")
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    private fun LazyColumnProgrammaticScrolling() {

        val coroutineScope = rememberCoroutineScope()

        val lazyScrollState = rememberLazyListState()
        var firstVisible = lazyScrollState.firstVisibleItemIndex
        LazyColumn(
            state = lazyScrollState,
            modifier = Modifier.fillMaxWidth()
        ){

            stickyHeader {
                Text(
                    text = "First Visible Index: $firstVisible",
                    style = MaterialTheme.typography.h1
                )
            }

            items( count = 1000) { index ->
                Text("Bobbins #$index")
            }
        }
        Button(
            onClick = {
                //the scrolling has to be done in a coroutineScope
                coroutineScope.launch {
                    //much better - with Lazy you scroll to the index.
                    lazyScrollState.animateScrollToItem( index = 4)
                }
            }
        ){
            Text("Push me")
        }

    }

    @Composable
    private fun AddingLazyItems() {


        LazyColumn{
            item {
                Text("Bobbins")
            }
        }

         LazyColumn{
             items( count = 1000) { index ->
                 Text("Bobbins #$index")
             }
         }

         val words = listOf("The", "Mighty", "Bobbins")
         LazyColumn{
             itemsIndexed( items = words){index, item ->
                Text("$index =  $item")
             }
         }



    }

    @Composable
    private fun ScrollableColumn() {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            repeat(100) {
                //Item
            }
        }
    }

    @Composable
    private fun ScrollableRow() {
        Row(Modifier.horizontalScroll(rememberScrollState())) {
            repeat(100) {
                //Item
            }
        }
    }

    @Composable
    @Preview
    fun Preview(){
        Display()
    }

}
