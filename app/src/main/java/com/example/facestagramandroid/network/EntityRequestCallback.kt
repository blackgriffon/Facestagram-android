package com.example.facestagramandroid.network

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

abstract class EntityRequestCallback : Callback {
    companion object {
        const val SERVER = "http://10.10.16.70:8085/"
    }
    private var onEntityResponse: OnEntityResponse? = null
    protected abstract var entityUrl: String

    protected fun fetch(callback: OnEntityResponse) {
        val url = SERVER + entityUrl
        onEntityResponse = callback
        val request = Request.Builder()
            .url(url)
            .build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(this)
    }

    override fun onFailure(call: Call, e: IOException) {
        onEntityResponse?.error()
        println(e.message)
    }

    override fun onResponse(call: Call, response: Response) {
        if (!response.isSuccessful) {
            println("Unsuccessful response from server.")
            println(response)
            return
        }

        val body = response.body()?.string()
        onEntityResponse?.success(JSONObject(body))
    }
}