package com.example.LearnKotlin.controller

import com.example.LearnKotlin.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class MemberController {
    var memberService: MemberService = MemberService()

    @Autowired
    fun MemberController(memberService: MemberService) {
        this.memberService = memberService
    }
}