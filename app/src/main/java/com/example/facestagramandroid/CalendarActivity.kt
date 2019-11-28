package com.example.facestagramandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calendar.*

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        //setting toolbar
        setSupportActionBar(findViewById(R.id.calendar_toolbar))
        //home navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Calendar")

        new_post.setOnClickListener {
            val intent = Intent(this, NewPostActivity::class.java)
            startActivity(intent)
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
        } android.R.id.home -> {
            Toast.makeText(this, "Go Back action", Toast.LENGTH_LONG).show()
            onBackPressed()
            true
        } else -> {
            //If we got here, the user's action was not recognized
            //Invoke the superclass to handle it
            super.onOptionsItemSelected(item)
        }

    }
}
