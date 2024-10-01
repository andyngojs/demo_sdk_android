package vn.vnpd.mylibrary

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import vn.vnpd.mylibrary.routes.SDKNavigation
import vn.vnpd.mylibrary.utils.showMessage

class MainActivityModule : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Đoạn này lấy data từ bên ngoài truyền vào (React Native) thông qua intent
        val baseURL = intent.getStringExtra("BASE_URL")
        val token = intent.getStringExtra("TOKEN")

        // hiện thị toast android thông báo
        if (baseURL !== null || token !== null) {
            showMessage(ctx = this, message = "${token.toString()}\n ${baseURL.toString()}")
        }

        enableEdgeToEdge()
        setContent {
            SDKNavigation(this@MainActivityModule)
        }
    }

    // param: activity context phải truyền từ thằng cha (nơi nó được gọi)
    // Example: testFx được gọi từ MainActivity (module: app) nên phải truyền context
    fun testFx(activity: Context) {
        showMessage(activity, "Test dataa")
    }
}
