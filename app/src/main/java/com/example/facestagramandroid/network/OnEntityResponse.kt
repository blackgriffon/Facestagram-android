package com.example.facestagramandroid.network

interface OnEntityResponse {
    fun error()
    fun success(contents: String?)
}