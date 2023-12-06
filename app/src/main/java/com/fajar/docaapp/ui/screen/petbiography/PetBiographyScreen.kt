package com.fajar.docaapp.ui.screen.petbiography

import android.widget.Toast
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.components.TextField

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
                onBtnClick = { }
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
    var weight by remember { mutableStateOf("") }
    val coffeeDrinks = arrayOf(
        "Dog",
        "Cat",
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    TextField(
        value = name,
        onValueChange = { name = it },
        placeholder = "Enter pet name",
        label = "Name",
        keyboardType = KeyboardType.Text
    )
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {

        TextField(
            value = selectedText,
            onValueChange = { },
            placeholder = "Choose pet type",
            label = "Type",
            keyboardType = KeyboardType.Text,
            readOnly = true,
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            coffeeDrinks.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        expanded = false
                    }
                )
            }
        }
    }

    TextField(
        value = weight,
        onValueChange = { weight = it },
        placeholder = "Enter pet weight",
        label = "Weight",
        keyboardType = KeyboardType.Number
    )
}

@Preview
@Composable
fun PetBiographyContentPrev() {
    PetBiographyScreen(rememberNavController())
}