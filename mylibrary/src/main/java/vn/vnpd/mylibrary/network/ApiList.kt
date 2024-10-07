package vn.vnpd.mylibrary.network

import org.json.JSONArray

val apiTestDomain = "https://jsonplaceholder.typicode.com"

val apiHandlerTest = ApiHandler(apiTestDomain)

class ApiList {
    fun getUserPosts(): JSONArray? {
        val data = apiHandlerTest.get("/users/1/posts")
        return data
    }
}