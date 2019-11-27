package com.example.facestagramandroid.network

import org.json.JSONObject

interface OnEntityResponse {
    fun error()
    fun success(json: JSONObject)
}