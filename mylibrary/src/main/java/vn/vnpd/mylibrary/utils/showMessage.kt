package vn.vnpd.mylibrary.utils

import android.content.Context
import android.widget.Toast

fun showMessage(ctx: Context, message: String) {
    Toast.makeText(ctx, message, Toast.LENGTH_LONG).show()
}