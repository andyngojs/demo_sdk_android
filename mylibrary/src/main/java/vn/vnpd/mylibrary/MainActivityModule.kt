package vn.vnpd.mylibrary

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import vn.vnpd.mylibrary.utils.formatDateTime
import vn.vnpd.mylibrary.ui.theme.Yellow40
import vn.vnpd.mylibrary.utils.showMessage
import vn.vnpd.mylibrary.viewmodel.EventManager

class MainActivityModule : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Đoạn này lấy data từ bên ngoài truyền vào (React Native) thông qua intent
        val baseURL = intent.getStringExtra("BASE_URL")
        val token = intent.getStringExtra("TOKEN")

        // hiện thị toast android thông báo
        if (baseURL !== "" || token !== "") {
            showMessage(ctx = this, message = "${token.toString()}\n ${baseURL.toString()}")
        }
        enableEdgeToEdge()
        setContent {
            GreetingPreview()
        }
    }

    // param: activity context phải truyền từ thằng cha (nơi nó được gọi)
    // Example: testFx được gọi từ MainActivity (module: app) nên phải truyền context
    fun testFx(activity : Context) {
        showMessage(activity, "Test dataa")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingPreview() {
    var isModalDate = remember { mutableStateOf(false) }
    var dateTimeState = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Yellow40,
                    titleContentColor = MaterialTheme.colorScheme.tertiary,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    actionIconContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Text("Demo SDK", fontSize = 24.sp)
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 12.dp)
            ) {
                Text(
                    "Date: ${dateTimeState.value}",
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = MaterialTheme.typography.titleMedium
                )

                TextButton(
                    onClick = { isModalDate.value = true },
                    enabled = true,
                    modifier = Modifier.padding(top = 25.dp)
                ) {
                    Text("Open Date picker", fontSize = 15.sp)
                }
            }
        }

        if (isModalDate.value) {
            DatePickerModal(
                onDateSelected = { selectedDate ->
                    val dateFormatted = formatDateTime(selectedDate)
                    dateTimeState.value = dateFormatted
                    EventManager.onClick(data = dateFormatted)
                },
                onDismiss = { isModalDate.value = false })
        }
    }
}