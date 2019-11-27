package com.example.facestagramandroid.network

import org.json.JSONObject

class PostRequest : EntityRequestCallback() {
    override val entityUrl: String
        get() = "post"

    override fun getEntityId(entity: JSONObject): Int {
        return entity.getInt("postId")
    }
}