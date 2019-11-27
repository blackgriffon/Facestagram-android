package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener

class PlaceListActicvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_list_acticvity)

        val listView = findViewById<ListView>(R.id.listView)
        val tubeLines = ArrayList<String>()
        val arrayAdaptor = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, tubeLines)
        listView.adapter = arrayAdaptor

        EntityRequest.place.getAll(object : OnEntityResponse {
            override fun success(contents: String?) {
                val json = JSONArray(JSONTokener(contents)?.nextValue())
                for (i in 0 until json.length()) {
                    tubeLines.add(json.getJSONObject(i).optString("name"))
                }
            }

            override fun error() {
                println("Failed")
            }
        })
    }
}
