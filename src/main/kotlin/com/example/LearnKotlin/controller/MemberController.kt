package com.example.LearnKotlin.controller

import com.example.LearnKotlin.domain.Member
import com.example.LearnKotlin.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController {

    var memberService: MemberService = MemberService()

    fun MemberController(memberService: MemberService) {
        this.memberService = memberService
    }

    @GetMapping("/members/new") // 주소창 URL 입력
    fun createForm(): String {
        return "members/createMemberForm"
    }

    @PostMapping("/members/new")
    fun create(form: MemberForm): String {
        var member: Member = Member()
        member.name = form.name
        println("member = " + member.name)
        memberService.join(member)
        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model): String {
        var members: MutableList<Member> = memberService.findMembers()
        model.addAttribute("members", members);
        return "members/memberList"
    }

}