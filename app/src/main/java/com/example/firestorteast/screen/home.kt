package com.example.firestorteast.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.firestorteast.UserViewModel


@Composable
fun home (navController: NavController, viewModel: UserViewModel){

    val user = viewModel.userData.collectAsStateWithLifecycle().value

    Column (modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {


        user?.let { profile ->

            Text(
                text = "UserName: ${profile.name}",
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 20.sp
            )
            Text(
                text = "Email: ${profile.email}",
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 20.sp
            )


        }
        Button(onClick = {navController.navigate("profile")}) {
            Text("profile page")
        }
    }
}