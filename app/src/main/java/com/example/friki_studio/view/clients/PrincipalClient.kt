package com.example.friki_studio.view.clients

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.friki_studio.R
import com.example.friki_studio.Routes

@Composable
fun PrincipalClient(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopBarContentClient(navController = navController)
        },
        bottomBar = {
            BoottomBarContentClient(navController = navController)
        }
    ){ paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Pantalla de cliente", color = Color.Black)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarContentClient(modifier: Modifier = Modifier, navController: NavHostController) {
    TopAppBar(
        title = { /* Título si es necesario */ },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logogris),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(100.dp)
                    .clickable { navController.navigate(Routes.ViewPrincipalClient.route) }
            )
        },
        actions = {
           IconButton(onClick = { navController.navigate(Routes.ViewProfile.route) }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Perfil", modifier = Modifier.size(30.dp))
            }
        }
    )
}

@Composable
fun BoottomBarContentClient(navController: NavHostController) {
    NavigationBar (
        modifier = Modifier.height(80.dp)
    ){
        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate(Routes.ViewPrincipalClient.route) },
            icon = {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "Inicio", fontSize = 10.sp)
                }
            }
        )
        NavigationBarItem(selected = false, onClick = { navController.navigate(Routes.ViewCategories.route) }, icon = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Icon(
                    Icons.Default.List,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Categorias", fontSize = 10.sp)
            }
        })
        NavigationBarItem(selected = false, onClick = { navController.navigate(Routes.ViewShoppingCart.route) }, icon = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
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