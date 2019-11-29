package com.example.facestagramandroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import kotlinx.android.synthetic.main.activity_booking.*
import org.json.JSONObject

class BookingActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        setSupportActionBar(findViewById(R.id.booking_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Booking")


        bookingRegist_button.setOnClickListener {
            Toast.makeText(this, "New Input", Toast.LENGTH_LONG).show()

            val bookingJson = JSONObject()

            bookingJson.put("bookingId", "0")
            bookingJson.put("placeId", "1")
            bookingJson.put("startDatetime", null)
            bookingJson.put("endDatetime", null)

            EntityRequest.booking.insert(bookingJson, object : OnEntityResponse {
                override fun error() {
                }
                override fun success(contents: String?) {
                    println(bookingJson)
                }
            })
        }

        val items = resources.getStringArray(R.array.category_array)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        var categoryId = 0

        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("MyTag","onNothingSelected")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0 -> {
                        categoryId = 1
                        println(categoryId)
                    } 1 -> {
                        categoryId = 2
                    } else -> {

                    }
                }
            }
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
