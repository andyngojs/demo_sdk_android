package vn.vnpd.mylibrary.ui.screens

sealed class Screen(val route: String) {
    object PaymentMethod: Screen("payment_method_screen")
    object PaymentConfirm: Screen("payment_confirm_screen")
}