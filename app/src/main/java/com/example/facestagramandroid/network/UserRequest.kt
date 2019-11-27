package com.example.facestagramandroid.network

import org.json.JSONObject

class UserRequest : EntityRequestCallback() {
    override val entityUrl: String
        get() = "user"

    override fun getEntityId(entity: JSONObject): Int {
        return entity.getInt("userId")
    }

}