package com.example.LearnKotlin.repository

import com.example.LearnKotlin.domain.Member;

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(Id: Long?): Member?
    fun findByName(name: String): Member?
    fun findAll(): MutableList<Member> = mutableListOf() // 초기화
}