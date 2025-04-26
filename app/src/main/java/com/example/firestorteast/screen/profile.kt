package com.example.firestorteast.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.firestorteast.UserViewModel

@Composable
fun profile(viewModel: UserViewModel,navController: NavController) {
    val user by viewModel.userData.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        user.let { data ->
            var name by rememberSaveable { mutableStateOf(data?.name ?: "") }

            var email by rememberSaveable { mutableStateOf(data?.email ?: "") }


            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )

            Button(onClick = {
                viewModel.dataupdata(email,name)
            }) { Text("Save data") }

            Button(onClick = {navController.navigate("home")}) {
                Text("Back to Home page")
            }


        }

    }


}
