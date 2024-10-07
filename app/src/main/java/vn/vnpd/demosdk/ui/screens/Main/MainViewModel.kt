package vn.vnpd.demosdk.ui.screens.Main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONArray
import java.io.IOException

data class List(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String,
)

class MainViewModel : ViewModel() {
    private val client = OkHttpClient()
    var list = mutableStateListOf<List>()
    var isLoading = mutableStateOf(false)

    fun getData() {
        isLoading.value = true
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                callAPI()
            }

            if (response!!.length() < 1) {
                return@launch
            }

            var listFormated = mutableListOf<List>()
            for (i in 0 until response!!.length()) {
                val obj = response!!.getJSONObject(i)

                listFormated.add(
                    List(
                        obj.getInt("userId"),
                        obj.getInt("id"),
                        obj.getString("title"),
                        obj.getString("body")
                    )
                )
            }
            list.addAll(listFormated)
            isLoading.value = false
        }
    }

    fun callAPI(): JSONArray? {
        val request =
            Request.Builder().url("https://jsonplaceholder.typicode.com/users/1/posts")
                .build()

        try {
            var response: Response = client.newCall(request).execute()
            if (!response.isSuccessful) return null

            return JSONArray(response.body?.string())
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }
}