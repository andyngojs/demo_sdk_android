package vn.vnpd.mylibrary.viewmodel

import android.util.Log

interface IMainActivity {
    fun onClickButton(data: String)
}

// create a single instance
object EventManager {
    var eventListeners: IMainActivity? = null

    fun onClick(data: String) {
       eventListeners?.onClickButton(data)
        Log.d("onClick", data)
    }
}