package com.example.facestagramandroid.network

import org.json.JSONObject

class BookingRequest : EntityRequestCallback() {
    override val entityUrl: String
        get() = "booking"

    override fun getEntityId(entity: JSONObject): Int {
        return entity.getInt("bookingId")
    }

}
