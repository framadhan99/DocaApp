package com.fajar.docaapp.ui.screen.petbiography

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.components.TextField
import com.fajar.docaapp.ui.navigation.Screen

@Composable
fun PetBiographyScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    ContainerPage(
        firstContent = {
            Text(
                "Pet Biography",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        },
        secondContent = {
            ContainerBox(
                btnText = "Save",
                messageText1 = "",
                messageText2 = "",
                content = { PetBiographyContent() },
                spacer = { },
                onBtnClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.GetStarted.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetBiographyContent(
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    val petType = arrayOf(
        "Dog",
        "Cat",
    )
    val genderOptions = listOf("Male", "Female")
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }

    var selectedOption by remember { mutableStateOf(genderOptions[0]) }
    var expandedType by remember { mutableStateOf(false) }
    var expandedBreed by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(petType[0]) }
    var selectedBreed by remember { mutableStateOf(petType[0]) }

    TextField(
        value = name,
        onValueChange = { name = it },
        placeholder = "Enter pet name",
        label = "Name",
        keyboardType = KeyboardType.Text
    )
    ExposedDropdownMenuBox(
        expanded = expandedType,
        onExpandedChange = { expandedType = !expandedType }
    ) {
        TextField(
            value = selectedType,
            onValueChange = {  },
            placeholder = "Choose pet type",
            label = "Type",
            keyboardType = KeyboardType.Text,
            readOnly = true,
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expandedType,
            onDismissRequest = { expandedType = false }
        ) {
            petType.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selectedType = item
                        expandedType = false
                    }
                )
            }
        }
    }
    ExposedDropdownMenuBox(
        expanded = expandedBreed,
        onExpandedChange = { expandedBreed = !expandedBreed }) {

        TextField(
            value = selectedBreed,
            onValueChange = { selectedBreed = it},
            placeholder = "Choose pet breed",
            label = "Breed",
            keyboardType = KeyboardType.Text,
            readOnly = true,
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expandedBreed,
            onDismissRequest = { expandedBreed = false }
        ) {
            petType.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selectedBreed = item
                        expandedBreed = false
                    }
                )
            }
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        genderOptions.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
                Text(option)
            }
        }
    }
    TextField(
        value = age,
        onValueChange = { age = it },
        placeholder = "Enter pet age",
        label = "Age",
        supportingText = "In month",
        keyboardType = KeyboardType.Number
    )
    TextField(
        value = color,
        onValueChange = { color = it },
        placeholder = "Enter pet color",
        label = "Color",
        keyboardType = KeyboardType.Text
    )
    TextField(
        value = weight,
        onValueChange = { weight = it },
        placeholder = "Enter pet weight",
        label = "Weight",
        supportingText = "In Kg",
        keyboardType = KeyboardType.Number
    )
}

@Preview
@Composable
fun PetBiographyContentPrev() {
    PetBiographyScreen(rememberNavController())
}