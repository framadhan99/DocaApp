package com.fajar.docaapp.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
    object GetStarted : Screen("getstarted")

    object PetBiography : Screen("petbiography")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Product : Screen("products")
    object HowTo : Screen("howto")

}