package com.example.facestagramandroid.network

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

abstract class EntityRequestCallback : Callback {
    enum class Method {
        GET,
        POST,
        PUT,
        DELETE
    }
    companion object {
        const val SERVER = "http://10.10.16.70:8085"
    }
    private var onEntityResponse: OnEntityResponse? = null
    protected abstract val entityUrl: String
    protected abstract fun getEntityId(entity: JSONObject): Int

    protected fun requestEntity(
        restUrl: String, contents: JSONObject?,
        method: Method, callback: OnEntityResponse) {
        val url = SERVER + restUrl
        onEntityResponse = callback
        val methodType = when (method) {
            Method.GET -> "GET"
            Method.POST -> "POST"
            Method.PUT -> "PUT"
            Method.DELETE -> "DELETE"
        }
        val body = when (method) {
            Method.GET -> null
            else -> RequestBody.create(
                MediaType.parse("application/json; charset=UTF-8"),
                contents?.toString())
        }
        val request = Request.Builder()
            .method(methodType, body)
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(this)
    }

    fun get(id: Int, response: OnEntityResponse) {
        requestEntity("/$entityUrl/$id",
        null, Method.GET, response)
    }

    fun getAll(response: OnEntityResponse) {
        requestEntity("/$entityUrl",
        null, Method.GET, response)
    }

    fun insert(entity: JSONObject, response: OnEntityResponse) {
        requestEntity("/$entityUrl",
            entity, Method.POST, response)
    }

    fun update(entity: JSONObject, response: OnEntityResponse) {
        requestEntity("/$entityUrl/${getEntityId(entity)}",
            entity, Method.PUT, response)
    }

    fun delete(entity: JSONObject, response: OnEntityResponse) {
        requestEntity("/$entityUrl/${getEntityId(entity)}",
            entity, Method.DELETE, response)
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
        onEntityResponse?.success(response.body()?.string())
    }
}