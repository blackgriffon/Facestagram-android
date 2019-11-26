package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_view)
    }

    fun buttonClick(view: View) {
        val connection = URL("http://10.10.16.70/palce/1").openConnection()
        val data = connection.inputStream.bufferedReader().readText()
    }

}
