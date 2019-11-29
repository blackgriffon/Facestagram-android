package com.example.facestagramandroid

import androidx.appcompat.app.AppCompatActivity

import android.view.View
import androidx.core.content.ContextCompat
import com.example.facestagramandroid.data.postlist.PostListViewAdapter
import com.example.facestagramandroid.data.postlist.PostListViewItem
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import org.json.JSONArray

import android.widget.*
import com.example.facestagramandroid.data.postlist.PostVO

import android.os.Bundle;
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_place_list_acticvity.*
import org.json.JSONObject
import org.json.JSONTokener
import java.util.ArrayList
import kotlin.random.Random


class MyPostAdapter : BaseAdapter() {

    var items = emptyArray<JSONObject>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun temp (i : Int): Int {
        var a = 0
        var tempInt = a + i
        return tempInt
    }
    private var listViewItemList = ArrayList<PostListViewItem>()

    var jsonArray : JSONArray? = null

    fun createJsonArray(item : Any) : Int{
        jsonArray = JSONArray(item.toString())
        return jsonArray!!.length()
    }
/*
    fun postJsonFarse(index : Int) : PostVO{
        val json = jsonArray!!.getJSONObject(index)
        for (item in items) {
            val post : PostVO = PostVO(
                item.getInt("postId"),
                json.getInt("userId"),
                json.getString("content"),
                json.getString("lastModified"),
                json.getString("planStartDatetime"),
                json.getString("planEndDatetime"),
                json.getInt("placeId"),
                json.getInt("accessibleLevelId")
            )
        }


        return post
    }
*/

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater
                .from(parent?.context)
                    //.inflate(android.R.layout.simple_list_item_1, parent, false)
                .inflate(R.layout.postlistview_item, parent, false)
            //simple_list_item_1
            val holder = ViewHolder()
            holder.postIdView = view.findViewById(R.id.postTextView1)
            holder.contentView = view.findViewById(R.id.postTextView2)
            view.tag = holder
        }

        val holder = view?.tag as ViewHolder
        val item = getItem(position)

        //val json = JSONObject(item.toString())
        //createJsonArray(item)
        items[position].getInt("userId").toString()
        //val voArray = ArrayList<PostVO>()

        /*
        for (item in items) {


         } */


        holder.postIdView?.text = items[position].getInt("userId").toString()
        holder.contentView?.text = items[position].getString("content")

     //   var jsonParsing = postJsonFarse(position)


      // holder.postIdView?.text = voArray.postid.toString()
      //  holder.contentView?.text = jsonParsing.content

        return view!!

    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        val item = getItem(position) as JSONObject
        return item.optLong("postId")
    }

    override fun getCount(): Int {
        return items.size
    }

    private inner class ViewHolder {
        internal var postIdView: TextView? = null
        internal var contentView: TextView? = null
    }
}



class PostListActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)
        //activity_post_list


        listView = findViewById(R.id.PostList_ListView)
        listView.adapter = MyPostAdapter()
        EntityRequest.post.getAll(object : OnEntityResponse {
            override fun success(contents: String?) {
                val json = JSONArray(contents)


                val adapter = listView.adapter as MyPostAdapter
                runOnUiThread {
                    adapter.items = Array(json.length()) {
                         json.getJSONObject(it)

                        /*
                        var jsonObject = json.getJSONObject(it)
                        var postId = jsonObject.getInt("postId")
                        var userId = jsonObject.getInt("userId")
                        var content = jsonObject.getString("content")
                        var lastModified = jsonObject.getString("lastModified")
                        var planStartDatetime = jsonObject.getString("planStartDatetime")
                        var planEndDatetime = jsonObject.getString("planEndDatetime")
                        var placeId = jsonObject.getInt("placeId")
                        var accessibleLevelId = jsonObject.getInt("accessibleLevelId")
                        var keyValue1 = jsonObject.getInt("keyValue1")
                        */

//            value[1].optInt("userId")
//            value[2].optString("content")

                    }



                }
                println("Finished reading json.")
            }

            override fun error() {
                println("Failed")
            }
        })

        /*
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
        */





/*
        val listView = findViewById<ListView>(R.id.PostList_ListView)
        val tubeLines = ArrayList<String>()
        val arrayAdaptor = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, tubeLines)
        listView.adapter = arrayAdaptor


        val testObject = JSONObject()
        testObject.put("userId", 1)
        testObject.put("content", "지금만나")
        testObject.put("lastmodified", "sysdate")
        testObject.put("planstartdatetime", "sysdate")
        testObject.put("planenddatetime", "null")
        testObject.put("placeid", "1")
        testObject.put("accessiblelevel", "1")


        EntityRequest.post.insert( testObject, object : OnEntityResponse{
            override fun success(contents: String?) {
                val json = JSONArray(JSONTokener(contents)?.nextValue())
                println(json)
            }
            override fun error() {
                println("Failed")
            }
        }

        )



        EntityRequest.post.getAll(object : OnEntityResponse {
            override fun success(contents: String?) {
                //println(JSONTokener(contents)?.nextValue())
                val json = JSONArray(contents)
                println(json)
                for (i in 0 until json.length()) {
                    tubeLines.add(json.getJSONObject(i).optString("userid"))
                }
            }
            override fun error() {
                println("Failed")
            }
        })
*/

        /*  //리스트뷰설정
        //var listview: ListView
        var adapter: PostListViewAdapter

        // Adapter 생성
        adapter = PostListViewAdapter()
        // 리스트뷰 참조 및 Adapter달기
        listView = findViewById<View>(R.id.PostList_ListView) as ListView
        listView.adapter = adapter
        var posts = mutableListOf<PostVO>()
        //var jsonarr : JSONArray = JSONArray()
        */

        /* //엔티티리퀘스트
        EntityRequest.post.getAll(object : OnEntityResponse {
            override fun success(contents: String?) {
                var json = JSONArray(contents)
                val adapter = listView.adapter as PostListViewAdapter

                                //json.length()
                for (i in 0 until 5) {
                    // tubeLines.add(json.getJSONObject(i).optString("userId"))
                   //println("optString:"+json.getJSONObject(i).optString("postId") )

//                    val appObject = json.getJSONObject(i)
//                    val userid = appObject.getString("postId")
//                    println("jsonobj:"+userid )

                    var postVO = PostVO()
                    postVO.postid = json.getJSONObject(i).optString("userId").toInt()
                    println("postVO.userId:"+postVO.userid)

                    postVO.content = json.getJSONObject(i).optString("content")
                    println("postVO.content:"+postVO.content)

                    posts.add(postVO)
                }

                    runOnUiThread{
                            adapter.addItem(
                        posts[0].userid.toString() ,
                        posts[0].content
                        )
                    }

//               var temp1 = posts[0].userid.toString()
//                var temp2 = posts[0].content
//
//                println("sc t1:"+temp1)
//                println("sc t2:"+temp2)

               // adapter.notifyDataSetChanged()
                // listView.adapter.notifyDataSetChanged()
            }

            override fun error() {
                println("Failed")
            }
        })
        */

        //println("밖으로:"+jsonarr.getJSONObject(1).optString("postId") )

/*
            var temp1 = ""
        var temp2 = "123"
        try {
            temp1 = posts[0].userid.toString()
            temp2 = posts[0].content

            println("t1:"+temp1)
            println("t2:"+temp2)
        }
        catch(e : Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }

      */

        /*
        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.one)!!,
        "Box", "Account Box Black 36dp"
        )

        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.two)!!,

            "Circle", "Account Circle Black 36dp"
        )
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.three)!!,
            "Ind", "Assignment Ind Black 36dp"
        )
        */

        /*
        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            // get item
            var item = parent.getItemAtPosition(position) as PostListViewItem

            var title = item.title
            var desc = item.desc
            //var icon = item.icon

            // TODO : use item data.

//            var icon: Drawable? = null
//    var title: String? = null
//    var desc: String? = null

             title = "1234"
            item.title = title
            adapter.notifyDataSetChanged()

        }
*/
/*
        btn_refresh.setOnClickListener {
            EntityRequest.post.getAll(object : OnEntityResponse {
                override fun success(contents: String?) {
                    val json = JSONArray(JSONTokener(contents)?.nextValue())
                    for (i in 0 until json.length()) {
                        tubeLines.add(json.getJSONObject(i).optString("name"))
                    }
                }

                override fun error() {
                    println("Failed")
                }
            })

        }

        */

    }



}
