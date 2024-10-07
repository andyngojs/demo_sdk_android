package vn.vnpd.mylibrary.ui.screens.PaymentConfirm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import vn.vnpd.mylibrary.ui.components.NavBar
import vn.vnpd.mylibrary.ui.theme.Yellow40

@Composable
fun PaymentConfirm(navController: NavController) {
    NavBar(title = "Xác nhận thanh toán", onBack = { navController.popBackStack() }) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Mã giao dịch: ")
                    Text("123333434444", textAlign = TextAlign.End)
                }
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Số tiền thanh toán: ")
                    Text("2.000.000", textAlign = TextAlign.End)
                }
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Phí giao dịch: ")
                    Text("2.000.000", textAlign = TextAlign.End)
                }
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Phí giao dịch: ")
                    Text("2.000.000", textAlign = TextAlign.End)
                }
            }


            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Tổng thanh toán: ", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "33.000.000",
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight(600),
                        color = Yellow40
                    )
                }

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