package vn.vnpd.demosdk.ui.screens.Main

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import vn.vnpd.demosdk.ui.screens.Screen
import vn.vnpd.demosdk.ui.theme.DemosdkTheme
import vn.vnpd.mylibrary.MainActivityModule
import vn.vnpd.mylibrary.ui.theme.Yellow40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun render(activity: Activity, navController: NavController, viewModel: MainViewModel = viewModel()) {

    LaunchedEffect(Unit) {
//        viewModel.getData()
    }

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

                if (viewModel.isLoading.value) {
                    CircularProgressIndicator(color = Yellow40, modifier = Modifier.width(50.dp))
                } else {
                    LazyColumn {
                        item() {
                            Text("Lists")
                        }

                        items(viewModel.list) { item ->
                            Column {
                                Text(item.title, color = Color.LightGray)
                                Text(item.body)
                            }
                        }
                    }
                }
            }
        }
    }
}