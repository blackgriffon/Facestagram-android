package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import okhttp3.*
import java.io.IOException

import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_view)

    }

    fun buttonClick(view: View) {
      //  val connection = URL("http://10.10.16.70/place/1").openConnection()
      //  val data = connection.inputStream.bufferedReader().readText()

        val url = "http://10.10.16.70:8085/place/1"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException){
                //에러 메세지 출력
            }
            override fun onResponse(call: Call, response: Response) {
                println(response?.body()?.string())
            }
        })

    }

}
