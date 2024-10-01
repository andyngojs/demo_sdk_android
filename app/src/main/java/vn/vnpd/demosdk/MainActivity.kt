package vn.vnpd.demosdk

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import vn.vnpd.demosdk.routes.NavigationStack
import vn.vnpd.demosdk.ui.theme.Yellow40

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
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
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize().padding(innerPadding),
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.padding(15.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Mã giao dịch: ")
                    Text("123333434444", textAlign = TextAlign.End, fontWeight = FontWeight(800))
                }
                Row(modifier = Modifier.padding(15.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Số tiền thanh toán: ")
                    Text("2.000.000", textAlign = TextAlign.End, fontWeight = FontWeight(800))
                }
                Row(modifier = Modifier.padding(15.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Phí giao dịch: ")
                    Text("2.000.000", textAlign = TextAlign.End, fontWeight = FontWeight(800))
                }
                Row(modifier = Modifier.padding(15.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Phí giao dịch: ")
                    Text("2.000.000", textAlign = TextAlign.End, fontWeight = FontWeight(800))
                }
            }


            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.padding(innerPadding).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Tổng thanh toán: ")
                    Text("2.000.000", textAlign = TextAlign.End, fontWeight = FontWeight(800), color = vn.vnpd.mylibrary.ui.theme.Yellow40)
                }

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    colors = ButtonColors(
                        containerColor = vn.vnpd.mylibrary.ui.theme.Yellow40,
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

