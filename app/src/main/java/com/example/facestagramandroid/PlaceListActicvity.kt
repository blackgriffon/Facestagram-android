package com.example.facestagramandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import org.json.JSONArray
import org.json.JSONObject
import android.widget.TextView
import com.example.facestagramandroid.data.postlist.PostListViewItem
import kotlinx.android.synthetic.main.activity_place_list_acticvity.*
import java.util.ArrayList
import kotlin.random.Random

class MyAdapter : BaseAdapter() {


    var items = emptyArray<JSONObject>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    private var listViewItemList = ArrayList<PostListViewItem>()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater
                .from(parent?.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            val holder = ViewHolder()
            holder.textView1 = view.findViewById(android.R.id.text1)
            view.tag = holder
        }

        val holder = view?.tag as ViewHolder
        val item = getItem(position)
        holder.textView1?.text = item.toString()

        return view!!

    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        val item = getItem(position) as JSONObject
        return item.optLong("placeId")
    }

    override fun getCount(): Int {
        return items.size
    }

    private inner class ViewHolder {
        internal var textView1: TextView? = null
    }
}

class PlaceListActicvity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_list_acticvity)

        listView = findViewById(R.id.placeList)
        listView.adapter = MyAdapter()
        EntityRequest.place.getAll(object : OnEntityResponse {
            override fun success(contents: String?) {
                val json = JSONArray(contents)
                val adapter = listView.adapter as MyAdapter
                runOnUiThread {
                    adapter.items = Array(json.length()) {
                        json.getJSONObject(it)
                    }
                }
                println("Finished reading json.")
            }

            override fun error() {
                println("Failed")
            }
        })

        clickMe.setOnClickListener {
            val pk = Random.nextInt(0, 100) + 1
            EntityRequest.user.get(pk, object : OnEntityResponse {
                override fun error() {
                    println("Failed")
                }

                override fun success(contents: String?) {
                    val json = JSONObject(contents)
                    val adapter = listView.adapter as MyAdapter
                    runOnUiThread {
                        adapter.items = Array(1) {
                            json
                        }
                    }
                }

            })
        }
    }
}

