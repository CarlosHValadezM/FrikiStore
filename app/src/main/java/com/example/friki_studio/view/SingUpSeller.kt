package com.example.friki_studio.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.friki_studio.R
import com.example.friki_studio.Routes

@Composable
fun SignUpSeller(navController: NavController, modifier: Modifier = Modifier) {
    var user by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .width(350.dp)
            )
            Spacer(modifier = Modifier.height(100.dp))
            TextField(
                value = name,
                onValueChange = { newText -> name = newText },
                label = { Text(text = "Nombre") },
                modifier = Modifier
                    .width(350.dp)
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text(text = "Correo electronico") },
                modifier = Modifier
                    .width(350.dp)
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = user,
                onValueChange = { newText -> user = newText },
                label = { Text(text = "Usuario") },
                modifier = Modifier
                    .width(350.dp)
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = password,
                onValueChange = { newText -> password = newText },
                label = { Text(text = "Contraseña") },
                modifier = Modifier
                    .width(350.dp)
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(Routes.ViewLogin.route) },
                modifier = Modifier
                    .width(250.dp)
            ) {
                Text(
                    text = "Registrarse como Vendedor",
                    fontSize = 16.sp
                )
            }
        }
    }
}