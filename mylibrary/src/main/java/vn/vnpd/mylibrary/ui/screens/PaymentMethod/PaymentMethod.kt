package vn.vnpd.mylibrary.ui.screens.PaymentMethod

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import vn.vnpd.mylibrary.ui.components.NavBar
import vn.vnpd.mylibrary.ui.screens.Screen
import vn.vnpd.mylibrary.ui.theme.Yellow40

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PaymentMethod(activity: Activity, navController: NavController, viewModel: PaymentMethodViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getData()
    }

    NavBar(title = "Phương thức thanh toán", onBack = { activity.finish() }) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState(), true),
            ) {
                Row(
                    modifier = Modifier
                        .drawBehind {
                            drawLine(
                                color = Color.DarkGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                        .clickable(onClick = { }, enabled = true),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .padding(
                                start = 10.dp, end = 10.dp, top = 14.dp, bottom = 14.dp
                            )
                            .fillMaxSize()
                            .align(Alignment.CenterVertically),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Localized description",
                            tint = Color.Black
                        )

                        Text(
                            "Ví bưu điện",
                            modifier = Modifier.padding(start = 35.dp),
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .drawBehind {
                            drawLine(
                                color = Color.DarkGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                        .clickable(onClick = { }, enabled = true),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .padding(
                                start = 10.dp, end = 10.dp, top = 14.dp, bottom = 14.dp
                            )
                            .fillMaxSize()
                            .align(Alignment.CenterVertically),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Localized description",
                            tint = Color.Black
                        )

                        Text(
                            "Viet QR",
                            modifier = Modifier.padding(start = 35.dp),
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Box() {
                Button(
                    onClick = {
                        navController.navigate(route = Screen.PaymentConfirm.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    colors = ButtonColors(
                        containerColor = Yellow40,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.background
                    )
                ) {
                    Text("Đồng Ý")
                }
            }

            if (viewModel.isLoading.value) {
                CircularProgressIndicator(color = Color.Yellow, modifier = Modifier.width(64.dp))
            } else {
                LazyColumn {
                    item() {
                        Text("Lists")
                    }

                    items(viewModel.userPosts) { item ->
                        Column {
                            Text(item.title, color = Color.DarkGray)
                        }
                    }
                }
            }
        }
    }
}