package com.example.LearnKotlin.service

import com.example.LearnKotlin.domain.Member
import com.example.LearnKotlin.repository.MemoryMemberRepository
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import java.lang.reflect.Executable
import kotlin.IllegalStateException

internal class MemberServiceTest {

    var memberService: MemberService = MemberService()
    var memberRepository: MemoryMemberRepository = MemoryMemberRepository()

//    @BeforeEach
//    fun beforeEach() {
//        memberService = MemberService()
//        memberRepository = MemoryMemberRepository()
//    } //DI 로직

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    fun join() {
        // given
        var member: Member = Member()
        member.name = "hello"

        // when
        val saveId: Long = memberService.join(member)

        // then
        var findMember: Member? = memberService.findOne(saveId)
        assertThat(member.name).isEqualTo(findMember?.name)
    }

    @Test
    fun overlapEx() {
        //given
        var member1: Member = Member()
        member1.name = "spring"

        var member2: Member = Member()
        member2.name = "spring"

        //when
        memberService.join(member1)
        // assertThrows, assertFailWith 보류(회원서비스 테스트 10:00)

        try{
            memberService.join(member2)
            fail()
        }catch(e: IllegalStateException){
            assertThat(e.message).isEqualTo("This member is already exist!")
        }

        //then
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}