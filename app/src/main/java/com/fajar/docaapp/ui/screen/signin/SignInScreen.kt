package com.fajar.docaapp.ui.screen.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.components.TextField
import com.fajar.docaapp.ui.navigation.Screen

@Composable
fun SignInScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    ContainerPage(
        firstContent = {
            Image(
                painter = painterResource(R.drawable.doca_small),
                contentDescription = null,
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .size(200.dp)
            )
        },
        secondContent = {
            ContainerBox(
                headlineText = "Welcome back",
                subText = "Please sign in to continue",
                btnText = "Sign In",
                messageText1 = "Don't have account? ",
                messageText2 = "Sign Up",
                spacer = {
                    Spacer(modifier = Modifier.height(132.dp))
                },
                content = {
                    SignInContent()
                },
                onBtnClick = {  },
                onTextClick = {
                    navController.navigate(Screen.SignUp.route) {
                        popUpTo(Screen.Welcome.route)
                    }
                }
            )
        }
    )
}

@Composable
fun SignInContent(
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { email = it },
        placeholder = "Enter your email address",
        label = "Email address",
        keyboardType = KeyboardType.Email
    )
    TextField(
        value = password,
        onValueChange = { password = it },
        placeholder = "Enter your password",
        label = "Password",
        keyboardType = KeyboardType.Password,
        passwordVisibility = true
    )
}

@Preview
@Composable
fun SignInScreenPrev() {
    SignInScreen(rememberNavController())
}