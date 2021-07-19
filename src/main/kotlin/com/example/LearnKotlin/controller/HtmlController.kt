package com.example.LearnKotlin.controller

import com.example.LearnKotlin.domain.MultipleParameter
import com.example.LearnKotlin.domain.Student
import com.example.LearnKotlin.service.AnnoClass
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
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

    // @Controller annotation 아래 모든 메서드에 공통적으로 맵핑
    @ModelAttribute("StringValue")
    fun annoModelAttri(): String {
        println("@ModelAttribute has been used")
        return "@ModelAttribute mapped by string data"
    }

    @ModelAttribute("ObjectValue")
    fun annoModelAttrForObj(student: Student): Student {
        return student
    }

    @GetMapping("hello-mvc")
    fun helloMVC(model: Model,
                 @RequestParam name: String,
                 @RequestParam num: Int): String {
        model.addAttribute("name", name);
        model.addAttribute("num", num);
        return "hello-mvc"
    }

    // 경로 URL 맵핑방식
    @GetMapping("pathVar/{name}/{num}/{bool}")
    fun pathVar(@PathVariable("name") name: String,
                @PathVariable("num") num: Int,
                @PathVariable("bool") bool: Boolean): String {
//        @PathVariable value없이 model을 통해 데이터 정의
//        model.addAttribute("name", name);
//        model.addAttribute("num", num);
//        model.addAttribute("bool", bool);
        println("@PathVariable 방식의 URL 접속")
        return "pathVar"
    }

    @GetMapping("hello-mvc2")
    @ResponseBody
    fun helloMvc(multiple: MultipleParameter): String{
        var k: AnnoClass = AnnoClass(hashMapOf(0 to "Neymar"))
        var n: AnnoClass = AnnoClass((hashMapOf(3 to "azar")))

        var a: HashMap<Int, String> = k.HashReturnFun()
        var m: HashMap<Int, String> = n.HashReturnFun()
        return "address: " + multiple.address + ", HashMap idx 0 = : " + a.get(0) + " " + m.get(3)
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

    @PostMapping("hey")
    @ResponseBody
    fun postFun(multiple: MultipleParameter): MultipleParameter{
        return multiple
    }

    @PostMapping("hey2")
    @ResponseBody
    fun postFun2(@RequestBody multiple: MultipleParameter): MultipleParameter{
        println("post 정상동작:" + multiple.address )
        return multiple
    }

//    @DeleteMapping("hello")
//    fun deleteFun() {
//        println("delete method")
//    }

    class Hello {
        var nickName: String = "닉네임"
        var num: Int = 100;
        var name = ""; // var은 getter, setter. val은 getter 내부 자체 생성
    }

}