package com.example.firestorteast


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firestorteast.screen.datacreate
import com.example.firestorteast.screen.home
import com.example.firestorteast.screen.login
import com.example.firestorteast.screen.profile


@Composable
fun appmodel(viewModel: UserViewModel) {

    val navController = rememberNavController()
    NavHost (navController = navController , startDestination = if (viewModel.currentUser !=null){"Home"}else{"login"}){
        composable("datawrite") {
            datacreate(navController, viewModel)

        }
        composable("Home") {
            home(navController, viewModel)

        }
        composable("login") {
            login(navController,viewModel)
        }
        composable("profile") {
            profile(viewModel,navController)
        }
    }

}