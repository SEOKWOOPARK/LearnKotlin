package com.example.LearnKotlin.repository

import com.example.LearnKotlin.domain.Member
import org.junit.jupiter.api.Assertions // Assertions.assertEquals(a, b)
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.assertj.core.api.Assertions.assertThat // assertThat 바로 호출

class MemoryMemberRepositoryTest {
    var repository: MemoryMemberRepository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
        println("it was execute : afterEach - Clear!")
    } // 각 테스트가 끝나면 데이터를 리셋 -> 의존 관계 방지


    // Test -> 순서 보장 없는 실행
    @Test
    fun save(){
        val member = Member() // 객체 선
        member.name = "spring"
        repository.save(member)

        val result = repository.findById(member.id)
//        Assertions.assertEquals(member, result)
//        Assertions.assertEquals(member, null)
        assertThat(member).isEqualTo(result) // 실제 동일여부 비교 로직
        println("it was execute : Save!")
    }

    @Test
    fun findByName(){
        val member1 = Member()
        member1.name = "spring1"
        repository.save(member1)

        val member2 = Member()
        member2.name = "spring2"
        repository.save(member2)

        val result: Member? = repository.findByName("spring1")
        assertThat(result).isEqualTo(member1)

        println("it was execute : findByName!")
    }

    @Test
    fun findAll() {
        val member1 = Member()
        member1.name = "spring1"
        repository.save(member1)

        val member2 = Member()
        member2.name = "spring2"
        repository.save(member2)

        val result: MutableList<Member> = repository.findAll()

        assertThat(result.size).isEqualTo(2)
        println("it was execute : findAll!")
    }


}