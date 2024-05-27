package com.example.friki_studio

sealed class Routes(val route: String){
    object ViewLogin: Routes("viewLogin")
    object ViewForgotPassword: Routes("viewForgotPassword")
    object ViewSignUp: Routes("viewSignUp")
    object ViewSignUpSeller: Routes("viewSignUpSeller")

    //Client
    object ViewPrincipalAdministrator: Routes("viewPrincipalAdministrator")
    object ViewPrincipalClient: Routes("viewPrincipalClient")
    object ViewCategories: Routes("viewCategories")
    object ViewProfile: Routes("viewProfile")
    object ViewShoppingCart: Routes("viewShoppingCart")
}