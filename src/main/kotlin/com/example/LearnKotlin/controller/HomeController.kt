package com.example.LearnKotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/") // spring container에 해당 컨트롤러 탐색 -> 찾으면 index.html 무시
    fun home(): String {
        return "home"
    }
}