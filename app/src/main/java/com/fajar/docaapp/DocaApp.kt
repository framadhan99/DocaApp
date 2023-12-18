package com.fajar.docaapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fajar.docaapp.ui.navigation.BottomBar
import com.fajar.docaapp.ui.navigation.Screen
import com.fajar.docaapp.ui.screen.getstarted.GetStartedScreen
import com.fajar.docaapp.ui.screen.home.HomeScreen
import com.fajar.docaapp.ui.screen.how_to.HowToScreen
import com.fajar.docaapp.ui.screen.petbiography.PetBiographyScreen
import com.fajar.docaapp.ui.screen.signin.SignInScreen
import com.fajar.docaapp.ui.screen.signup.SignUpScreen
import com.fajar.docaapp.ui.screen.welcome.WelcomeSreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Welcome.route) {
            WelcomeSreen(navController)
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Screen.SignIn.route) {
            SignInScreen(navController)
        }
        composable(Screen.GetStarted.route) {
            GetStartedScreen(navController)
        }
        composable(Screen.PetBiography.route) {
            PetBiographyScreen(navController)
        }
        composable(Screen.HowTo.route){
            HowToScreen()
        }
    }
}