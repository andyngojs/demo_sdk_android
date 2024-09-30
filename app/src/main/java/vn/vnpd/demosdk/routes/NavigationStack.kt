package vn.vnpd.demosdk.routes

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import vn.vnpd.demosdk.ui.screens.DetailScreen
import vn.vnpd.demosdk.render
import vn.vnpd.demosdk.ui.screens.Screen

@Composable
fun NavigationStack(activity: Activity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            render(activity, navController)
        }
        composable(
            route = Screen.Detail.route + "?text={text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            DetailScreen(text = it.arguments?.getString("text") as String)
        }
    }
}