package com.fajar.docaapp.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
    object GetStarted : Screen("getstarted")

    object PetBiography : Screen("petbiography")
}