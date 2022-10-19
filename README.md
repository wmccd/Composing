# Composing Notes

## 20 Compose State and Recomposition


* Recomposition only impacts Composables that use the state value by changed
* *remember* to maintain state 
* *remember* - use *bv* instead of *value*
* *rememberSaveable* to state after system updates such device rotation, font size change
* Unidirectional flow: Any Composable that has interactive values should have the state passed in and the updates passed out, rather than maintaining its own state


## 21 Composition Local

* State should be passed to a Composable but it can be cumbersome if it has to pass down multiple layers.
* Composition Local allow value declared at a higher level to be available further down the tree
* Composition Local is not a global variable but is only available to any child composables in the tree below the point where it is declared.
* Two types: 
	1. staticCompositionLocalOf() - used for storing values that are unlikely to change. When it does change it triggers a recomposition of the entire tree beneath where the value is assigned.
	2. 	compositionLocalOf() - Can be used for often changed values as will only trigger recomposition on composables where the state is accessed.	 	

## 22 Compose Slot API

* You can inject Composable functions as parameters into Composable functions.

```
@Composable
private fun ScreenContent(){
	value1: Int, 
	value2: String,
	onTextChangedCallback: (String) -> Unit,
	onSwitchCheckedCallback: (Boolean) -> Unit,
	displayText: @Composable () -> Unit,
	displaySwitch: @Composable: () -> Unit
}
```


## 23 Compose Slot API Example

Useful pattern

```
    @Composable
    private fun Slots() {
    
    	 //remember the state
        var linearSelected by remember {mutableStateOf(false) }
        var imageSelected by remember{ mutableStateOf(true) }
    
        //updating the state
        val onLinerClick = { value: Boolean -> linearSelected = value }
        val onImageClick = { value: Boolean -> imageSelected = value }

		 //	display the content
		 //when user interacts with the screen the callbacks fire, the state is updated and the composable functions recompose with the updated state,
        ScreenContent(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onTitleClick = onImageClick,
            onLinearClick = onLinerClick,
            titleContent = {
               	when(imageSelected){
                   true -> { //display something }
                   false -> { //display something else }               
               }
            },
            progressContent = {
					when(linearSelected){
                   true -> { //display something }
                   false -> { //display something else }               
               }
            }
        )
    }

```

## 24 Modifiers

* Built in composables can have parameters that are a specific to that Composable

```
Text( "My Vacation", fontSize=40.dp, fontWeight=FontWeight.Bold)
```
* Modifiers are general in that they can be applied to any Composable
	* borders
	* padding
	* background
	* size requirements
	* event handlers
	* gestures
	* etc	

* Order matters in the modifier
	
<img width="882" alt="Screenshot 2022-10-19 at 14 07 35" src="https://user-images.githubusercontent.com/13928099/196700174-5ec9b7dd-c619-411e-a6cd-bb90befbe46b.png">

 <img width="919" alt="Screenshot 2022-10-19 at 14 07 18" src="https://user-images.githubusercontent.com/13928099/196700107-129a5286-6370-4dd7-91f7-838313dda7f5.png">

* Common Built in Modifiers
	* **background** - draws a solid background behind the composable
	* **clickable** - specifies a handler when clicked and causes UI ripple 
	* **clip** - clips the composable to specified shape (eg rounded corners)
	* **fillMaxHeight** - composable expands to max height allowed by parent
	* **fillMaxSize** - composable expands to max height and width allowed by parent	
	* **fillMaxWidth** - composable expands to max width allowed by parent
	* **offset** - positions the composable the specified distance from its current position along x and y axis.
	* **padding** - the ubiquitous padding
	* **rotate** - rotates composable around its centre point by the specified number of degrees
	* **scale** - increase/decrease the size of the composable by the specified scale factor
	* **size** - used to specify the height and width of a composable

* Modifiers can be chained.

```
DisplayImage(
	id = R.drawable.coast1,
    modifier = sizeOnlyModifier
        .then(borderOnlyModifier)
        .then(roundOnlyModifier)
)
```	

## 25 Row and Columns

* Row - uses verticalAlignment and horizontalArrangement 

```	
	Row(
	    modifier = Modifier
	        .size(
	            height = 60.dp,
	            width = 150.dp
	        )
	        .background(Color.Red),
	    verticalAlignment = Alignment.Top,
	    horizontalArrangement = Arrangement.SpaceBetween
	){
```
	
* Column - uses horizontalAlignment and verticalArrangement 

	
```
	Column(
	    modifier = Modifier.height(height = 60.dp),
	    horizontalAlignment = Alignment.End,
	    verticalArrangement = Arrangement.Bottom
	){
	    TextCell(words = "2")
	}
```
    
* Weight - controls the relative width or height or child elemets

```
	Row(
	    modifier = Modifier
	        .width(width = 150.dp)
	        .background(color = Color.Magenta),
	
	){
	    TextCell(words = "1",
	        Modifier.weight( weight = 0.2f)
	    )
	    TextCell(words = "2",
	        Modifier.weight( weight = 0.3f)
	    )
	    TextCell(words = "3",
	        Modifier.weight( weight = 0.5f)
	    )
	}
```    

* Row and Scope Modifiers - you can override the behaviour of a parent modifier. Look at the RowScope inside the Row lambda






