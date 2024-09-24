package vn.vnpd.demosdk

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import vn.vnpd.demosdk.utils.formatDateTime
import vn.vnpd.mylibrary.GreetingPreview

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview()
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@Preview(showBackground = true, showSystemUi = true)
//fun GreetingPreview() {
//    var isModalDate = remember { mutableStateOf(false) }
//    var dateTimeState = remember { mutableStateOf("") }
//
//    DemosdkTheme(dynamicColor = false) {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    colors = TopAppBarColors(
//                        containerColor = MaterialTheme.colorScheme.primary,
//                        titleContentColor = MaterialTheme.colorScheme.tertiary,
//                        scrolledContainerColor = MaterialTheme.colorScheme.background,
//                        actionIconContentColor = MaterialTheme.colorScheme.primary,
//                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
//                    ),
//                    title = {
//                        Text("Demo SDK", fontSize = 24.sp)
//                    },
//                )
//            },
//        ) { innerPadding ->
//            Column(
//                modifier = Modifier
//                    .padding(innerPadding)
//                    .fillMaxSize()
//            ) {
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .padding(top = 12.dp)
//                ) {
//                    Text(
//                        "Date: ${dateTimeState.value}",
//                        modifier = Modifier.padding(bottom = 16.dp),
//                        style = MaterialTheme.typography.titleMedium
//                    )
//
//                    TextButton(
//                        onClick = { isModalDate.value = true },
//                        enabled = true,
//                        modifier = Modifier.padding(top = 25.dp)
//                    ) {
//                        Text("Open Date picker", fontSize = 15.sp)
//                    }
//                }
//            }
//
//            if (isModalDate.value) {
//                DatePickerModal(
//                    onDateSelected = { selectedDate ->
//                        dateTimeState.value = formatDateTime(selectedDate)
//                    },
//                    onDismiss = { isModalDate.value = false })
//            }
//        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (selectDate: Long?) -> Unit, onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(onDismissRequest = onDismiss, confirmButton = {
        TextButton(onClick = {
            Log.d("selectedDate ", formatDateTime(datePickerState.selectedDateMillis))
            onDateSelected(datePickerState.selectedDateMillis)
            onDismiss()
        }) {
            Text("OK")
        }
    }, dismissButton = {
        TextButton(onClick = onDismiss) {
            Text("Cancel")
        }
    }) {
        DatePicker(state = datePickerState)
    }
}
