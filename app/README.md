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

