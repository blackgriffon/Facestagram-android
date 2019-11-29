package com.example.facestagramandroid.data.postlist

import java.io.Serializable
import java.time.LocalDateTime

class PostVO  {

    //: Serializable
//    constructor(
//        postid: Int,
//        userid: Int,
//        content: String?,
//        lastmodified: String?,
//        planstartdatetime: String?,
//        planenddatetime: String?,
//        placeid: Int,
//        accessiblelebel: Int
//    ) {
//        this.postid = postid
//        this.userid = userid
//        this.content = content
//        this.lastmodified = lastmodified
//        this.planstartdatetime = planstartdatetime
//        this.planenddatetime = planenddatetime
//        this.placeid = placeid
//        this.accessiblelebel = accessiblelebel
//
//    }


    var postid: Int = 0
    var userid: Int = 0
    var content: String? = ""
    var lastmodified: String? = "sysdate"
    var planstartdatetime: String? = null
    var planenddatetime: String? = null
    var placeid = 0
    var accessiblelebel = 0


}