package com.example.LearnKotlin.service

import com.example.LearnKotlin.domain.Member
import com.example.LearnKotlin.repository.MemberRepository
import com.example.LearnKotlin.repository.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
// 스프링 컨테이너(빈)에 서비스 로직을 저장. 컨트롤러 생성시 가져다 사용
// cmd + shift + T : 테스트 바로가기

class UserService(private val userRepository: MemberRepository){}

@Configuration
@ComponentScan("com.rcod.lifelog")
class ApplicationConfig {
}

@Component
class ComponentExample{
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    //.....
}

@Configuration
class configExample{

    @Bean
    fun BeanFunc(a: MutableList<Int>): MutableList<Int>{
       return a
    }
}


@Service
class MemberService {
    var memberRepository:MemberRepository = MemoryMemberRepository()

    fun join(member: Member): Long { // 회원가입 로직
        val start: Long = System.currentTimeMillis() // for printing time

        try {
            validateDuplicateMember(member) // option + cmd + m -> 메서드 함수 추출
            memberRepository.save(member)
            return member.id
        }finally {
            val finish: Long = System.currentTimeMillis()
            val timeMs: Long = finish - start
            println("join = " + timeMs + "ms")
        }
    }

    private fun validateDuplicateMember(member: Member) {
        // name 중복 방지
        //        var result: Member? = memberRepository.findByName(member.name)
        //        if(result != null) { throw IllegalStateException("This member is already exist!")}
        memberRepository.findByName(member.name)?.also {
            throw IllegalStateException("This member is already exist!")
        }
    }

    fun findMembers(): MutableList<Member> { // 전체 회원조회
        val start: Long = System.currentTimeMillis()

        try {
            return memberRepository.findAll()
        } finally {
            val finish: Long = System.currentTimeMillis()
            val timeMs: Long = finish - start;
            println("findMembers " + timeMs + "ms")
        }
    }

    fun findOne(memberId: Long): Member? { // Id 회원조회
        return memberRepository.findById(memberId)
    }

}