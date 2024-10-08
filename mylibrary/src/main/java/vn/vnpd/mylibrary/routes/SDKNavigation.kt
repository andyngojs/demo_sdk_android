package vn.vnpd.mylibrary.routes

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import vn.vnpd.mylibrary.ui.screens.PaymentConfirm.PaymentConfirm
import vn.vnpd.mylibrary.ui.screens.PaymentMethod.PaymentMethod
import vn.vnpd.mylibrary.ui.screens.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SDKNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.PaymentMethod.route) {
        composable(route = Screen.PaymentMethod.route) {
            PaymentMethod(navController)
        }
        composable(route = Screen.PaymentConfirm.route) {
            PaymentConfirm(navController)
        }
    }
}