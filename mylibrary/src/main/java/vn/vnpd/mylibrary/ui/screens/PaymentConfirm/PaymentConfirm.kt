package vn.vnpd.mylibrary.ui.screens.PaymentConfirm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import vn.vnpd.mylibrary.ui.components.NavBar

@Composable
fun PaymentConfirm(navController: NavController) {
    NavBar(title = "Xác nhận thanh toán", onBack = { navController.popBackStack() }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box() {
                Row(modifier = Modifier.padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Mã giao dịch: ")
                    Text("123333434444")
                }
            }
        }
    }
}