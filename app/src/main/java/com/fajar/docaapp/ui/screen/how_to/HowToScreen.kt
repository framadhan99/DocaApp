package com.fajar.docaapp.ui.screen.how_to

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.components.ContainerBox
import com.fajar.docaapp.ui.components.ContainerHowTo
import com.fajar.docaapp.ui.components.ContainerPage
import com.fajar.docaapp.ui.components.HeadlineText
import com.fajar.docaapp.ui.theme.DocaTheme

@Composable
fun HowToScreen() {
    ContainerPage(
        firstContent = {
            HeadlineText(title = "Take care your dog")
        },
        secondContent = {
            ContainerHowTo(
                headlineText = "How to care of Pucci",
                content = { HowToContent() }
            )
        }

    )
}


@Composable
fun HowToContent(){
    Box (
        modifier = Modifier.height(900.dp)
    ){
        Column (
            horizontalAlignment = Alignment.Start,
            ){
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Vet visit",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.howto_vet),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400)
                )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Exercise needs",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.howto_exercise),
                fontSize = 12.sp,
                fontWeight = FontWeight(400)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Dental care",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.howto_dental),
                fontSize = 12.sp,
                fontWeight = FontWeight(400)
            )
        }
    }
}

@Preview
@Composable
fun HowToScreenPreview() {
    DocaTheme {
        HowToScreen()
    }
}
