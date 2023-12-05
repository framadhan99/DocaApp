package com.fajar.docaapp.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.navigation.Screen

@Composable
fun WelcomeSreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState())
                .padding(top = 56.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.doca),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Text("Your trusted companion in dog & cat care excellence. Let's embark on a journey of wellness together! \uD83D\uDC3E",
                textAlign = TextAlign.Center,
                modifier = Modifier.width(240.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.SignUp.route)
                }
            ) {
                Text("Start Now!")
            }
            Spacer(modifier = Modifier.height(72.dp))
            Row(
                modifier = Modifier.padding(bottom = 40.dp)
            ) {
                Text(
                    "Already have account? ",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    "Sign in",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { navController.navigate(Screen.SignIn.route) }
                )
            }
        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
//    WelcomeSreen()
}