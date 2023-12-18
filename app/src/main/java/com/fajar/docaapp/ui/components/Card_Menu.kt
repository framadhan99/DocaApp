package com.fajar.docaapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.theme.DocaTheme


@Composable
fun CardMenu(
    image: Int,
    title: String,
    modifier: Modifier = Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .shadow(
                elevation = 3.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x4D000000),
                ambientColor = Color(0x4D000000)
            )
            .width(86.dp)
            .height(86.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(size = 12.dp)
            )

    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp),
                painter = painterResource(image),
                contentDescription = null,
            )
            Text(
                text = title,
                fontSize = 14.sp,
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardMenuPreview(){
    DocaTheme {
        CardMenu(
            image = R.drawable.menu_doca,
            title = "Title"
        )
    }
}