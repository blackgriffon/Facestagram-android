package com.example.facestagramandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import kotlinx.android.synthetic.main.first_view.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_view)

        next_button.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)

            //start your next acitvity
            startActivity(intent)
        }
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
