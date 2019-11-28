package com.example.facestagramandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
