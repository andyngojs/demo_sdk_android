package vn.vnpd.demosdk

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

import vn.vnpd.mylibrary.GreetingPreview
import vn.vnpd.mylibrary.MainActivityModule
import vn.vnpd.mylibrary.utils.showMessage
import vn.vnpd.mylibrary.viewmodel.MainActivityViewModel

class MainActivity : ComponentActivity() {
    val viewModel = MainActivityViewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Call function from library MainActivityModule (need pass context)
        MainActivityModule().testFx(this@MainActivity)

        enableEdgeToEdge()
        setContent {
            GreetingPreview(MainActivityViewModel())
        }
    }

    fun handleDateSelected(date: String): Unit {
        showMessage(this, "handleDateSelected callback: $date")
    }
}
