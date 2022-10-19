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

 

