package com.example.facestagramandroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import kotlinx.android.synthetic.main.activity_new_post.*
import org.json.JSONObject

class NewPostActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        setSupportActionBar(findViewById(R.id.newPost_toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("New Post")

        go_booking.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
        }

        bookingRegist_button.setOnClickListener {
            val json = JSONObject()

            json.put("postId", "0")
            json.put("userId", "1")
            json.put("content", "${newPost_inputtext.editText?.text}")
            json.put("lastModified", null)
            json.put("planStartDatetime", null)
            json.put("planEndDatetime", null)
            json.put("placeId", "1")
            json.put("accessibleLevelId", "1")

            EntityRequest.post.insert(json, object : OnEntityResponse {
                override fun error() {
                    println("error")
                }
                override fun success(contents: String?) {
                    println(json)
                }

            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.calendar_tag -> {
            //User chose the "Menu" item
            Toast.makeText(this, "Go Post action", Toast.LENGTH_LONG).show()
            val intent = Intent(this, PostListActivity::class.java)
            startActivity(intent)
            true
        } else -> {
            Toast.makeText(this, "Go Back action", Toast.LENGTH_LONG).show()
            onBackPressed()
            true
        }

    }
}
