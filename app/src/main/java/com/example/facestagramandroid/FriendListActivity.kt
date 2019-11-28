package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import kotlinx.android.synthetic.main.activity_friend_list.*
import kotlinx.android.synthetic.main.first_view.*

class FriendListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_list)
    }
}
