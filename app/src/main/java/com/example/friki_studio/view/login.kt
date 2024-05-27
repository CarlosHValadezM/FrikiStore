package com.example.friki_studio.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.friki_studio.R
import com.example.friki_studio.Routes
import com.example.friki_studio.viewmodel.auth.AuthVM

@Composable
fun Login(navController: NavController, modifier: Modifier = Modifier) {
    var user by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val authViewModel: AuthVM = viewModel()

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
                onClick = {
                    //navController.navigate(Routes.ViewPrincipalClient.route)
                    authViewModel.loginVM("Javier","1234")

                },
                modifier = Modifier
                    .width(250.dp)
            ) {
                Text(
                    text = "Iniciar sesión",
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            ForgotPassword(onClick = { navController.navigate(Routes.ViewForgotPassword.route) })
            Spacer(modifier = Modifier.height(5.dp))
            RegistAccount(onClick = { navController.navigate(Routes.ViewSignUp.route) })
            Spacer(modifier = Modifier.height(5.dp))
            RegistAccountSeller(onClick = { navController.navigate(Routes.ViewSignUpSeller.route) })
        }
    }
}


@Composable
fun ForgotPassword(onClick: () -> Unit) {
    val text = buildAnnotatedString {
        append("¿Olvidaste tu contraseña? ")
        pushStringAnnotation("Clickable", "Click aqui")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Click aqui")
        }
        pop()
    }

    Text(
        text = text,
        modifier = Modifier
            .clickable(onClick = onClick),
        style = TextStyle(
            fontSize = 14.sp
        )
    )
}

@Composable
fun RegistAccount(onClick: () -> Unit) {
    val text = buildAnnotatedString {
        append("¿No tienes una cuenta? ")
        pushStringAnnotation("Clickable", "Registrate")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Registrate")
        }
        pop()
    }

    Text(
        text = text,
        modifier = Modifier
            .clickable(onClick = onClick),
        style = TextStyle(
            fontSize = 14.sp
        )
    )
}

@Composable
fun RegistAccountSeller(onClick: () -> Unit) {
    val text = buildAnnotatedString {
        append("¿Quieres unirte como vendedor? ")
        pushStringAnnotation("Clickable", "Registrate")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Registrate")
        }
        pop()
    }

    Text(
        text = text,
        modifier = Modifier
            .clickable(onClick = onClick),
        style = TextStyle(
            fontSize = 14.sp
        )
    )
}