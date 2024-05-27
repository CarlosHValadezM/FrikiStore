package com.example.friki_studio.view.clients

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.friki_studio.R
import com.example.friki_studio.Routes

@Composable
fun Categories(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBarContentClient(navController = navController)
        },
        bottomBar = {
            BoottomBarContentCategories(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black) // Fondo oscuro
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "GÉNEROS",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White // Texto blanco
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CategoryBox(iconId = R.drawable.controlicon, label = "VIDEOJUEGOS", onClick = { /* Manejar click */ })
                        CategoryBox(iconId = R.drawable.seriesicon, label = "SERIES", onClick = { /* Manejar click */ })
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CategoryBox(iconId = R.drawable.animeicon, label = "ANIME", onClick = { /* Manejar click */ })
                        CategoryBox(iconId = R.drawable.otracosa, label = "OTRAS", onClick = { /* Manejar click */ })
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "LO MÁS POPULAR",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White // Texto blanco
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CategoryBox(iconId = R.drawable.tendencia, label = "TENDENCIAS", onClick = { /* Manejar click */ })
                        CategoryBox(iconId = R.drawable.producto, label = "PRODUCTOS", onClick = { /* Manejar click */ })
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryBox(iconId: Int, label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(16.dp)) // Fondo oscuro y esquinas redondeadas
            .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(16.dp)) // Borde gris con esquinas redondeadas
            .clickable { onClick() }, // Hacer la caja clickable
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = label, style = MaterialTheme.typography.bodyMedium, color = Color.White) // Texto blanco
        }
    }
}


@Composable
fun BoottomBarContentCategories(navController: NavHostController) {
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
        NavigationBarItem(selected = true, onClick = { navController.navigate(Routes.ViewCategories.route) }, icon = {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Icon(
                    Icons.Default.List,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = "Categorias", fontSize = 10.sp)
            }
        })
        NavigationBarItem(selected = false, onClick = { navController.navigate(Routes.ViewShoppingCart.route) }, icon = {
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