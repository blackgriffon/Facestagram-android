package com.example.facestagramandroid.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import org.json.JSONArray

class PostAdapter (context: Context, resource: Int, list: ArrayList<JSONArray>)
    : ArrayAdapter<JSONArray>(context, resource, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }
}