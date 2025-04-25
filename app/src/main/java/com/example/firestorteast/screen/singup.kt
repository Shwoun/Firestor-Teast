package com.example.firestorteast.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firestorteast.UserViewModel



@Composable
fun datacreate(navController: NavController, viewModel: UserViewModel) {

    var Name by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column (modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        OutlinedTextField(
            value = Name,
            onValueChange = { Name = it },
            label = { Text("Name") },
            singleLine = true
        )
        OutlinedTextField(
            value = Email,
            onValueChange = { Email = it },
            label = { Text("Email") },
            singleLine = true
        )
        OutlinedTextField(
            value = Password,
            onValueChange = { Password = it },
            label = { Text("Password") },
            singleLine = true
        )
        Button(onClick = {
            if (Name.isBlank() || Email.isBlank() || Password.isBlank()) {
                Toast.makeText(context, "fil the rewij", Toast.LENGTH_LONG).show()
            } else {
                viewModel.createUser(Email, Name, Password, navController)
            }
        }) {
            Text("Create")
        }
    }
}