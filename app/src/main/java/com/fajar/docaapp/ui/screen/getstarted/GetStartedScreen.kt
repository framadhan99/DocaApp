package com.fajar.docaapp.ui.screen.getstarted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.components.OutlinedButtonWithIcon
import com.fajar.docaapp.ui.navigation.Screen

@Composable
fun GetStartedScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    ContainerPage(
        firstContent = {
            Text(
                "Welcome to DoCa",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                "Complete your pet profile",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        },
        secondContent = {
            ContainerBox(
                btnText = "Next",
                messageText1 = "",
                messageText2 = "",
                content = {
                    GetStartedContent()
                },
                spacer = { Spacer(modifier = Modifier.height(32.dp)) },
                onBtnClick = {
                    navController.navigate(Screen.PetBiography.route) {
                        popUpTo(Screen.GetStarted.route)
                    }
                }
            )
        }
    )
}

@Composable
fun GetStartedContent(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_place_holder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(400.dp)
            .clip(RoundedCornerShape(30.dp))
    )
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButtonWithIcon(
            text = "Gallery",
            icon = R.drawable.baseline_folder_24
        )
        OutlinedButtonWithIcon(
            text = "Camera",
            icon = R.drawable.baseline_camera_alt_24
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
}

@Preview
@Composable
fun GetStartedPrev() {
    GetStartedScreen(rememberNavController())
}