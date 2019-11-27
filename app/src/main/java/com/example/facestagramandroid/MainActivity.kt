package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var testId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_view)
    }

    fun buttonClick(view: View) {
        println("testId: $testId")
        EntityRequest.user.getByPk(testId, object: OnEntityResponse {
            override fun error() {
                println("Error")
            }

            override fun success(json: JSONObject) {
                println(json)
                testId++
            }
        })
    }

}
