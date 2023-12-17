package com.fajar.docaapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fajar.docaapp.R
import com.fajar.docaapp.ui.components.CardMenu
import com.fajar.docaapp.ui.components.HeadlineText
import com.fajar.docaapp.ui.components.VerticalSpace
import com.fajar.docaapp.ui.theme.DocaTheme
import okhttp3.internal.wait

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant)

    ) {
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            VerticalSpace(height = 58.dp)
            Box(
//                modifier = Modifier.height(80.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    HeadlineText(title = "Hello User!")
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clip(shape = RoundedCornerShape(100.dp))
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Text(
                            text = "A", fontSize = 16.sp

                        )

                    }
                }
            }
            VerticalSpace(height = 30.dp)
            ConstraintLayout() {
                val (topBox, bottomBox) = createRefs()

                Box(modifier = Modifier
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
                    .background(
                        MaterialTheme.colorScheme.surface,
                        RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)
                    )
                    .padding(horizontal = 16.dp)

                    .fillMaxWidth()
                    .height(900.dp)
                    .constrainAs(bottomBox) {
                        top.linkTo(topBox.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        VerticalSpace(height = 70.dp)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            CardMenu(image = R.drawable.menu_doca, title = "Petcare")
                            CardMenu(image = R.drawable.menu_location, title = "Petshop")
                            CardMenu(image = R.drawable.menu_location, title = "Petshop")

                        }
                        VerticalSpace(height = 32.dp)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = "Task",
                                fontSize = 22.sp,
                            )
                            Text(
                                text = "See all", fontSize = 14.sp, color = Color(0xFF00658E)

                            )
                        }
                        VerticalSpace(height = 6.dp)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn()
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            LazyColumn(
                            ) {
                                items(3){
                                    Row (
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = 56.dp,
                                                end = 36.dp,
                                                top = 16.dp,
                                                bottom = 16.dp
                                            )


                                    ){
                                        val checked = remember { mutableStateOf(false) }
                                        Column {
                                            Text(text = "Hygiene", fontSize = 16.sp)
                                            Text(text = "Take a bath", fontSize = 14.sp)
                                        }
                                        Checkbox(checked = checked.value,
                                            onCheckedChange = { isChecked ->
                                                checked.value = isChecked
                                            })
                                    }
                                    Divider()
                                }

                            }

                        }

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 16.dp)
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

                    .fillMaxWidth()
                    .height(116.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(start = 16.dp)
                    .constrainAs(topBox) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }

                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(76.dp)
                                .width(76.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(color = MaterialTheme.colorScheme.primaryContainer)
                        ) {
                            Text(
                                text = "A", fontSize = 16.sp

                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Pucci",
                                fontSize = 22.sp,
                            )
                            Box(

                            ) {
                                Row(
                                    verticalAlignment = Alignment.Top,
                                    horizontalArrangement = Arrangement.SpaceBetween,

                                    ) {
                                    Column(
                                        horizontalAlignment = Alignment.Start
                                    ) {
                                        Text(
                                            text = "Dog | Shih Tzu",
                                            fontSize = 14.sp,
                                        )
                                        Text(
                                            text = "1 year 2 month",
                                            fontSize = 14.sp,
                                        )
                                    }

                                }
                            }
                        }
                        Spacer(modifier = Modifier.width(90.dp))
                        Icon(
                            Icons.Rounded.PlayArrow, contentDescription = null
                        )

                    }

                }
            }

        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    DocaTheme {
        HomeScreen()
    }
}