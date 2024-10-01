package vn.vnpd.mylibrary.network

import org.json.JSONArray

val apiTestDomain = "https://jsonplaceholder.typicode.com"

class ApiList {
    private val apiHandlerTest = ApiHandler(apiTestDomain)

    fun getUserPosts(): JSONArray? {
        val data = apiHandlerTest.get("/users/1/posts")
        return data
    }
}