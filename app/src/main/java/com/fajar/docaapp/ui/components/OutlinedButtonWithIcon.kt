package com.fajar.docaapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fajar.docaapp.R

@Composable
fun OutlinedButtonWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int,
) {
    OutlinedButton(
        onClick = {  }
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}