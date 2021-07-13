package com.example.LearnKotlin.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {

    @GetMapping("hello")
    fun hello(model: Model): String {
        model.addAttribute("data", "Kotlin Spring!")
        return "hello"
    }

    @GetMapping("goodbye")
    fun goodbye(model: Model): String {
        model.addAttribute("data", "goodbye kotlin")
        return "goodbye"
    }

    @GetMapping("hello-mvc")
    fun helloMVC(model: Model,
                 @RequestParam name: String,
                 @RequestParam num: Int,
                 @RequestParam bool: Boolean,): String {
        model.addAttribute("name", name);
        model.addAttribute("num", num);
        model.addAttribute("bool", bool);
        return "hello-mvc"
    }



    @GetMapping("hello-api")
    @ResponseBody
    fun helloString(model: Model, @RequestParam name: String): String {
        return "입력한 API Data : " + name
    }

    @GetMapping("hello-api2")
    @ResponseBody
    fun helloApi(model: Model, @RequestParam name: String,
                            @RequestParam num: Int): Hello {
        val hello = Hello(); // new연산자 필요없음. val x = 객체
        println("${hello.nickName}") // ${object.property}
        println("${hello.num}")
        hello.name = name; // set 필요 없이 그냥 할당.
        hello.num = num;
        return hello;
    }

    class Hello {
        var nickName: String = "닉네임"
        var num: Int = 100;
        var name = ""; // var은 getter, setter. val은 getter 내부 자체 생성
    }

}