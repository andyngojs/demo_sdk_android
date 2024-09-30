package vn.vnpd.demosdk

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import vn.vnpd.demosdk.routes.NavigationStack
import vn.vnpd.demosdk.ui.screens.Screen

import vn.vnpd.demosdk.ui.theme.DemosdkTheme
import vn.vnpd.mylibrary.MainActivityModule
import vn.vnpd.demosdk.ui.theme.Yellow40

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
//            GreetingPreview()
            NavigationStack(this@MainActivity)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
@Preview(showSystemUi = true)
fun GreetingPreview() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Yellow40,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    actionIconContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Text("Phương thức thanh toán", fontSize = 20.sp)
                },
                navigationIcon = {
                    IconButton(
                        onClick = { }, colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)) {
            FlowColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState(), true)
                ,
                maxItemsInEachColumn = 100
            ) {
                FlowRow(
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
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 14.dp, bottom = 14.dp)
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

                FlowRow(
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
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, top = 14.dp, bottom = 14.dp)
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
                    onClick = { },
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
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun render(activity: Activity, navController: NavController) {
    DemosdkTheme(dynamicColor = false) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        scrolledContainerColor = MaterialTheme.colorScheme.background,
                        actionIconContentColor = MaterialTheme.colorScheme.primary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    title = {
                        Text("Hello World", fontSize = 24.sp, textAlign = TextAlign.Center)
                    },
                )
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Button(onClick = {
                    val intent = Intent(activity, MainActivityModule::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    activity.startActivity(intent)
                }, modifier = Modifier.padding(start = 20.dp)) {
                    Text("Open my SDK")
                }

                Button(onClick = {
                    navController.navigate(route = Screen.Detail.route + "?text=Hellodnjdndjndj")
                },  modifier = Modifier.padding(start = 20.dp)) {
                    Text("go to Detail screen")
                }
            }
        }
    }
}
