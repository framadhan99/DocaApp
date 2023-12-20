package com.fajar.docaapp.ui.screen.getstarted

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.components.OutlinedButtonWithIcon
import com.fajar.docaapp.ui.navigation.Screen
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.fajar.docaapp.BuildConfig
import com.fajar.docaapp.utils.getImageUri
import java.util.Objects
import androidx.compose.runtime.remember as remember

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
    val context = LocalContext.current
    val file = getImageUri(context)
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) {
        selectedImageUri = it
    }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) {
        if (it) {
            selectedImageUri = file
        }
    }

    AsyncImage(
        model = selectedImageUri,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        error = painterResource(R.drawable.ic_place_holder),
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
            icon = R.drawable.baseline_folder_24,
            onClick = {
                photoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }
        )
        OutlinedButtonWithIcon(
            text = "Camera",
            icon = R.drawable.baseline_camera_alt_24,
            onClick = {
                cameraLauncher.launch(file)
            }
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
}

@Preview
@Composable
fun GetStartedPrev() {
    GetStartedScreen(rememberNavController())
}