package com.example.facestagramandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_booking.*

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        setSupportActionBar(findViewById(R.id.booking_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Booking")


        regist_button.setOnClickListener {
            Toast.makeText(this, "New Input", Toast.LENGTH_LONG).show()

        }

        spinner.prompt = "Place Category"
        val items = resources.getStringArray(R.array.category_array)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position) {
                    0 -> {

                    } 1 -> {

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
