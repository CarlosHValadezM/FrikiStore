package com.example.friki_studio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.friki_studio.ui.theme.Friki_StudioTheme
import com.example.friki_studio.view.ForgotPassword
import com.example.friki_studio.view.Login
import com.example.friki_studio.view.SignUp
import com.example.friki_studio.view.SignUpSeller
import com.example.friki_studio.view.vendedor.PrincipalVendedor
import com.example.friki_studio.view.clients.Categories
import com.example.friki_studio.view.clients.PrincipalClient
import com.example.friki_studio.view.clients.Profile
import com.example.friki_studio.view.clients.ShoppingCart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Friki_StudioTheme {
                val navigationController = rememberNavController()

                NavHost(navController = navigationController, startDestination = Routes.ViewLogin.route){
                    composable(Routes.ViewLogin.route) { Login(navController = navigationController)}
                    composable(Routes.ViewForgotPassword.route) { ForgotPassword(navController = navigationController) }
                    composable(Routes.ViewSignUp.route) { SignUp(navController = navigationController) }
                    composable(Routes.ViewSignUpSeller.route) { SignUpSeller(navController = navigationController) }

                    //Client
                    composable(Routes.ViewPrincipalClient.route) { PrincipalClient(navController = navigationController) }
                    composable(Routes.ViewPrincipalAdministrator.route) { PrincipalVendedor(navController = navigationController) }
                    composable(Routes.ViewProfile.route) { Profile(navController = navigationController) }
                    composable(Routes.ViewCategories.route) { Categories(navController = navigationController) }
                    composable(Routes.ViewShoppingCart.route) { ShoppingCart(navController = navigationController) }
                }
            }
        }
    }
}