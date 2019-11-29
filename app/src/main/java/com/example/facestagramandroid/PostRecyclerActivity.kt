package com.example.facestagramandroid


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.activity_post_recycler.*

import com.bumptech.glide.Glide
import com.example.facestagramandroid.data.postlist.PostListViewAdapter
import com.example.facestagramandroid.data.postlist.PostVO
import com.example.facestagramandroid.network.EntityRequest
import com.example.facestagramandroid.network.OnEntityResponse
import org.json.JSONArray

class PostRecyclerActivity : AppCompatActivity() {



    class RecyclerViewAdapter(val postList:ArrayList<PostVO>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

        //아이템의 갯수
        override fun getItemCount(): Int {
            return postList.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return ViewHolder(v)
        }

        //this method is binding the data on the list
        override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
            holder.bindItems(postList[position])
        }


        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            fun bindItems(postData : PostVO){

//                //이미지표시
////                Glide.with(itemView.context).load(data.photo)
////                    .into(itemView.imageView)
                itemView.textView2.text = postData.postid.toString()
                itemView.textView3.text = postData.content
                //itemView.imageView_photo.setImageBitmap(data.photo)

                //각각의 아이템 클릭시
                itemView.setOnClickListener({
                    //여기서 토스터를 어떻게?
                    Toast.makeText(itemView.context, "아이템 '${postData.postid}'를 클릭했습니다.", Toast.LENGTH_LONG).show()
                })
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_recycler)



        //임시로 사용할 데이터 실제로는 대부분 DB에서 가져 올듯...
        /*
        val posts = arrayListOf<PostVO>(
            User("홍길동","hong@naver.com"),
            User("이순신","lee@naver.com"),
            User("강감찬","kang@naver.com"),
            User("을지문덕","eulji@naver.com"),
            User("광개토대왕","kwang@naver.com"),
            User("임꺽정","im@naver.com")
        )
        */
        val posts = arrayListOf<PostVO>()



        var listview: ListView
        //var adapter: RecyclerViewAdapter

        //레이아웃매니저 설정
        my_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        my_recycler_view.setHasFixedSize(true)
        val adapter = my_recycler_view.adapter as RecyclerViewAdapter

  /*
        EntityRequest.post.getAll(object : OnEntityResponse {
            override fun success(contents: String?) {
                var json = JSONArray(contents)
                //val adapter = listView.adapter as PostListViewAdapter


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
                    my_recycler_view.adapter = RecyclerViewAdapter(posts)
//                    adapter.bin(
//                        posts[0].userid.toString() ,
//                        posts[0].content
//                    )
                }

                // adapter.notifyDataSetChanged()
                // listView.adapter.notifyDataSetChanged()
            }

            override fun error() {
                println("Failed")
            }
        })
*/

        //어답터 설정


        /*
        //임시로 사용할 데이터를 arrayList에 담아 둔다. 나중에는 공공데이터로 대체 할 예정이다.
        val bookList = arrayListOf<Book>(
            Book("서울도서관", "코틀린 하루만에 배우기", "홍길동", "영림사", "2019", "어쩌고 저쩌고 가단한 책에 대한 소개"),
            Book("서울도서관", "계란 완벽하게 삶는 방법", "강감찬", "나잘난", "2019", "어쩌고 저쩌고 가단한 책에 대한 소개"),
            Book("서울도서관", "짐벌로 기막힌 영상 촬영방법", "이짐벌", "영림사", "2019", "어쩌고 저쩌고 가단한 책에 대한 소개"),
            Book("서울도서관", "옆집 철수보다 사진 잘 찍는 방법", "김기사", "영림사", "2019", "어쩌고 저쩌고 가단한 책에 대한 소개"),
            Book("서울도서관", "지구의 마지막 날", "키아누 리브스", "영림사", "2019", "어쩌고 저쩌고 가단한 책에 대한 소개")
        )


        //레이아웃매니저 설정
        my_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        my_recycler_view.setHasFixedSize(true)

        //어답터 설정
        my_recycler_view.adapter = RecyclerViewAdapter(bookList)
        */

    }

    //Object Class 이 얼마나 간단한가!
    data class User(val name: String, val email : String)


}