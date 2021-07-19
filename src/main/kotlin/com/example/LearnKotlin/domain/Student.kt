package com.example.LearnKotlin.domain

import org.omg.CORBA.Object

class Student {
    var name: String = "kane"
    var studentId: Long = 30L
    var address: String = "London"
    var todayAttendance: Boolean = false
    var Goals: MutableList<Int> = mutableListOf<Int>(3, 10, 5)
    var Assists: MutableList<String> = mutableListOf<String>("1","10")

//    object SeasonRecord {
//        var Goals = mutableListOf<Int>(30, 40, 20)
//        var Assists = mutableListOf("2", "3", "1")
//    }
}