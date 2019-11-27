package com.example.facestagramandroid.network

class UserRequest : EntityRequestCallback() {
    override var entityUrl: String = ""
        get() = "user/$field"

    fun getByPk(id: Int, response: OnEntityResponse) {
        entityUrl = "$id"
        fetch(response)
    }
}