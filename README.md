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

Arrange in the direction of flow

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

<img width="783" alt="Screenshot 2022-10-19 at 20 35 23" src="https://user-images.githubusercontent.com/13928099/196787813-f95fac42-7827-449d-be70-04eb7f64242d.png">


## 26 Boxes

* Row and Column organize children in a horizontal row or a vertical column.
* Box Layout stacks its children on top of each other
* The order is stacking is defined by the order of declaration with the first child the bottom of the stack.
* Clip the box
	* CircleShape 
	```.clip(CircleShape)
	```
	* RoundedCornerShape
	```
	.clip(RoundedCornerShape(30.dp))
	```
	* RoundedCornerShape
	```
	.clip(CutCornerShape(30.dp))
	```
	
## 27 Custom Layout Modifiers

* **Constraints**: the rules that dicatehow Composables are aligned and distanced from each other.	

## 29 Constraint Layouts

* **Constraints**: the rules that dicatehow Composables are aligned and distanced from each other.
* **Margins**: a form of constraint that specifies a fixed distance - *dp based*
* **Opposing Constraints**: two constraints operating on the same axis on a single composable are referred to as opposing constraints - *% based*
* **Constraint Bias**: when *Opposing Constraints* apply the Bias allows one contsraint to be have a a higer or lower percentage.
* **Chains**: allows for two + Composables to be defined as part of a group. Chains can be applied to items in a vertical or horizontal axis. How the items in the chain are spaced and sized.
	* Spread Chain - composables in a chain are spread evenly with space outide the first and last elements  
	* Spread Inside Chain - first and last composables aligned against the start and end of the container	
	* Weighted Chain - no spacing and size of each composable defined by the weights given
	* Packed Chain - the composables in the chain are packed together woithout spacing
* **Guidelines**: Additional invisible elememnts that can be used to help constrain against.
* **Barriers**: Addition invisible elements that can be used to help prevent overlapping composables. Useful when composables can dynamically expand and contract (think change of text)


## 30 Constraint Layouts Example

* Preview lines
	* Straight line: margin
	* Zig-zag lines:opposing constraints
	* Zig-zag with straight section: opposing constraint with margin

<img width="287" alt="Screenshot 2022-10-21 at 22 13 10" src="https://user-images.githubusercontent.com/13928099/197290902-e2485065-dad6-4b1d-a96f-0c96722c0ca6.png">

* Chains

```
	Chains(chainStyle = ChainStyle.Spread)
	Chains(chainStyle = ChainStyle.SpreadInside)
	Chains(chainStyle = ChainStyle.Packed)
```

<img width="297" alt="Screenshot 2022-10-21 at 22 43 50" src="https://user-images.githubusercontent.com/13928099/197294941-bb05eaf7-d1d4-4035-915f-29926d953206.png">

## 32 Lists and Grids

* **Scrollable**
	* You can make Columns and Rows scroll but for performance reasons this is not recommended for long lists.
	* LazyColumn and LazyRow scroll by default 


	```
	    Row(Modifier.horizontalScroll(rememberScrollState())){
	        repeat(100){
	            //Item
	        }
	    }
	
	    Column(Modifier.verticalScroll(rememberScrollState())){
	        repeat(100){
	            //Item
	        }
	    }
	```

* **Programmable Scrolling** 
	* Columns and Rows can only scroll to a pixel measurement, not an item
	* LazyColumn and LazyRow scroll to an item
	* Programmable scrolling takes place in a coroutine - so need to grab a reference to the current CoroutineScope
* Sticky headers are nice
* In a LazyColumn use *firstVisibleItemIndex* to find first visible item

```
        val lazyScrollState = rememberLazyListState()
        var firstVisible = lazyScrollState.firstVisibleItemIndex
        LazyColumn(
            state = lazyScrollState,
            modifier = Modifier.fillMaxWidth()
        ){
           stickyHeader {
                Text(
                    text = "First Visible Index: $firstVisible",
                    style = MaterialTheme.typography.h3
                )
            }
            items{
               ...
```

* LazyVerticalGrid modes:
	* GridCells.Adaptive - fills out the space available  



## 44 Navigation
    
* New screens are *pushed* onto the backstack, and *popped* off the the backstack  
* The navigation controller handles all the navigation between destinations and managing the nagivation stack. This is represented by the *NavHostController* class. 
* The navigation host (*NavHost*)is added to the interface layout of an activity and serves as a placeholder for the destinations through which the user will navigate.
* A NavHost is initiated with a NavController object and a *navigation graph*.   
* The navigation graph consists of all the composables that are available as navigation destinations within the context of the navigation controller. The destinations are expressed as *routes*.
* Use a sealed class or enum instead of hard coding routes
* Use *popUpTo* to pop items off the stack back to the specified destination. 
	* Use *inclusive = true* to pop the destination off the stack before performing the navigation.
	* Use *launchSingleTop = true* to prevent the addition of multiple instances of the same destination at the top of the stack
* 

