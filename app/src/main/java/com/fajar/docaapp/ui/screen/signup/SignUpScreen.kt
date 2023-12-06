package com.fajar.docaapp.ui.screen.signup

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
import com.fajar.docaapp.ui.components.TextField
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.navigation.Screen

@Composable
fun SignUpScreen(
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
                headlineText = "Create an Account!",
                btnText = "Sign Up",
                messageText1 = "Already have account? ",
                messageText2 = "Sign In",
                spacer = {
                    Spacer(modifier = Modifier.height(32.dp))
                },
                content = {
                    SignUpContent()
                },
                onBtnClick = {
                    navController.navigate(Screen.GetStarted.route) {
                        popUpTo(Screen.Welcome.route) {
                            inclusive = true
                        }
                    }
                },
                onTextClick = {
                    navController.navigate(Screen.SignIn.route) {
                        popUpTo(Screen.Welcome.route)
                    }
                }
            )
        }
    )
}

@Composable
fun SignUpContent(
    modifier: Modifier = Modifier
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    TextField(
        value = fullName,
        onValueChange = { fullName = it },
        placeholder = "Enter your full name",
        label = "Full name",
        keyboardType = KeyboardType.Text
    )
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
    TextField(
        value = passwordConfirm,
        onValueChange = { passwordConfirm = it },
        placeholder = "Enter your confirm password",
        label = "Confirm password",
        keyboardType = KeyboardType.Password,
        passwordVisibility = true
    )
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignUpScreen(rememberNavController())
}