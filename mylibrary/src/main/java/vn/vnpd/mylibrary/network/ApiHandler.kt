package vn.vnpd.mylibrary.network

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.IOException

class ApiHandler {
    private val httpClient = OkHttpClient()
    private var _baseDomain = ""

    constructor(baseDomain: String) {
        this._baseDomain = baseDomain
    }

    fun getApiUrl(endpoint: String): String {
        return this._baseDomain + endpoint
    }

    fun get(endpoint: String): JSONArray {
        val apiUrl = this.getApiUrl(endpoint)
        val request = Request.Builder().url(apiUrl).get().build()

        try {
            val response = baseApiHandler(request)
            return JSONArray(response)
        } catch (e: IOException) {
            throw IOException("error_api_get: " + e)
        }
    }

    private fun baseApiHandler(request: Request): String? {
        val response = httpClient.newCall(request).execute()

        try {
            if (!response.isSuccessful) return null

            if (response.body == null) return null

            return response.body?.string()
        } catch (e: IOException) {
            throw IOException("Error_baseApiHandler: " + e)
        }
    }
}