package com.example.friki_studio.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.friki_studio.R
import com.example.friki_studio.Routes

@Composable
fun ForgotPassword(navController: NavController, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp) // Para agregar un poco de margen alrededor
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .width(350.dp) // Ancho ajustado a 350 dp
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = "Ingresa tu correo electrónico.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(350.dp) // Ancho ajustado a 350 dp
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text(text = "Correo electrónico") },
                modifier = Modifier
                    .width(350.dp) // Ancho ajustado a 350 dp
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "En caso de coincidir con alguno de nuestros registros, se te enviará un correo para restablecer tu contraseña.",
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
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
                    text = "Recuperar contraseña",
                    fontSize = 18.sp
                )
            }
        }

    }
}