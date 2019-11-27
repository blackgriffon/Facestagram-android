package com.example.facestagramandroid.network

class PlaceRequest : EntityRequestCallback() {
    override var entityUrl: String = ""
        get() = "place/$field"

    fun getByPk(id: Int, response: OnEntityResponse) {
        entityUrl = "$id"
        fetch(response)
    }
}