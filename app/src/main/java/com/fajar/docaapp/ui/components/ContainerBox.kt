package com.fajar.docaapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ContainerBox(
    modifier: Modifier = Modifier,
    headlineText: String? = null,
    subText: String? = null,
    btnText: String,
    messageText1: String,
    messageText2: String,
    content: @Composable () -> Unit,
    spacer: @Composable () -> Unit,
    onBtnClick: () -> Unit,
    onTextClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surface,
                RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (headlineText != null) {
                Text(
                    headlineText,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            if (subText != null) {
                Text(
                    subText,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            content()

            Spacer(modifier = Modifier.height(4.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onBtnClick() }
            ) {
                Text(btnText)
            }

            spacer()
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                Text(
                    messageText1,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    messageText2,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onTextClick() }
                )
            }
        }
    }
}