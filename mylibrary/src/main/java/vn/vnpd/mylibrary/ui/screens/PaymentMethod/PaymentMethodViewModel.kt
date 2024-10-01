package vn.vnpd.mylibrary.ui.screens.PaymentMethod

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vn.vnpd.mylibrary.network.ApiList

data class List(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String,
)

class PaymentMethodViewModel: ViewModel() {
    val apiList = ApiList()
    var userPosts = mutableStateListOf<List>()
    var isLoading = mutableStateOf(false)

    fun getData() {
        isLoading.value = true

        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                apiList.getUserPosts()
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
            userPosts.addAll(listFormated)
            isLoading.value = false
        }
    }
}