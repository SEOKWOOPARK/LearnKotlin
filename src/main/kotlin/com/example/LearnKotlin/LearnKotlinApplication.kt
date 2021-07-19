package com.example.LearnKotlin

import com.example.LearnKotlin.service.AnnoClass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.MessageSource
import java.util.*
import kotlin.collections.HashMap

@SpringBootApplication
class LearnKotlinApplication{}

open class MyParent {
	var a: Int = 10
	open fun methodFunc(){
		println("original method")
	}
}

class MyChild: MyParent(){
	override fun methodFunc(){
		println("This overriding method comes from ")
	}
}

data class User(val name: String = "", val id: Int = 0){}

fun main(args: Array<String>) {
	runApplication<LearnKotlinApplication>(*args)
	var user1: User = User("kane", 5)
	var user2 = user1.copy(name="son")
	println("id = ${user1.id}, name = ${user1.name}")
	println("변경된 data class의 name = ${user2.name}")

}





