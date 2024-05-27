package com.example.friki_studio.view.clients

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.friki_studio.Routes

@Composable
fun ShoppingCart(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBarContentClient(navController = navController)
        },
        bottomBar = {
            BoottomBarContentShoppingCart(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(paddingValues)
        ) {
            Text(
                text = "VISTA RÁPIDA A TU CARRITO",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start) // Alinea el texto a la izquierda
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ContentShoppingCartEmpty()
            }
        }
    }
}

@Composable
fun ContentShoppingCartEmpty(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.ShoppingCart,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tu carrito está vacío",
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun BoottomBarContentShoppingCart(navController: NavHostController) {
    NavigationBar (
        modifier = Modifier.height(80.dp)
    ){
        NavigationBarItem(selected = false, onClick = { navController.navigate(Routes.ViewPrincipalClient.route) }, icon = {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Inicio", fontSize = 10.sp)
            }
        })
        NavigationBarItem(selected = false, onClick = { navController.navigate(Routes.ViewCategories.route) }, icon = {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Icon(
                    Icons.Default.List,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Categorias", fontSize = 10.sp)
            }
        })
        NavigationBarItem(selected = true, onClick = { navController.navigate(Routes.ViewShoppingCart.route) }, icon = {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Carrito", fontSize = 10.sp)
            }
        })
    }
}