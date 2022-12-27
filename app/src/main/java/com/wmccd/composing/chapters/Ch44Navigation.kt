package com.wmccd.composing.chapters

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class Ch44Navigation {

    @Composable
    fun Display() {
        val navController = rememberNavController()
        CreateRoutes(navController)

        Column() {

//            enumValues<Routes>().forEach {
//
//            }

            Button(onClick = {
                navController.navigate(Routes.Home.route)
            } ){
                Text("Navigate To ${Routes.Home.route}")
            }

            Button(onClick = {
                navController.navigate(Routes.Customers.route){
                    popUpTo(Routes.Home.route)
                }
            } ){
                Text("Navigate To ${Routes.Customers.route}")
            }

            Button(onClick = {
                navController.navigate(Routes.Purchases.route){
                    popUpTo(Routes.Home.route){
                        inclusive = true
                    }
                }
            } ){
                Text("Navigate To ${Routes.Purchases.route}")
            }

        }


    }

    @Composable
    private fun CreateRoutes(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Routes.Home.route) {

            composable(Routes.Home.route) {
                Home()
            }

            composable(Routes.Customers.route) {
                Customers()
            }

            composable(Routes.Purchases.route) {
                Purchases()
            }

            composable(Routes.Purchases.route + "/{customerName}") { backStoryEntry ->

                val customerName = backStoryEntry.arguments?.getString("customerName")

                Purchases(customerName)
            }
        }
    }


    @Composable
    private fun Home(){
        Text(Routes.Home.route )
    }

    @Composable
    private fun Customers(){
        Text(Routes.Customers.route)
    }

    @Composable
    private fun Purchases(){
        Text(Routes.Purchases.route)
    }

    @Composable
    @Preview
    private fun Preview(){

    }

}




enum class Routes(val route: String){
    Home("home"),
    Customers("customers"),
    Purchases("purchases")
}

