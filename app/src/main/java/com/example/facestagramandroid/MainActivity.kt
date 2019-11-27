package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var testId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_view)
    }

    fun buttonClick(view: View) {
        val testObject = JSONObject()
        testObject.put("userId", 1)
        testObject.put("email", "android@gmail.com")
        testObject.put("password", "1234")
        testObject.put("name", "안드로이드")
        testObject.put("profileImage", null)

        EntityRequest.user.get(1, object : OnEntityResponse {
            override fun error() {
                println("Error")
            }

            override fun success(contents: String?) {
                println(JSONObject(contents))
            }
        })

        /*
        EntityRequest.user.update(testObject, object : OnEntityResponse {
            override fun error() {
                println("Error")
            }

            override fun success(contents: String?) {
                println("Success")
            }
        })
        */
    }

}
