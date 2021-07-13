package com.example.LearnKotlin.repository

import com.example.LearnKotlin.domain.Member
import org.springframework.stereotype.Repository

@Repository
class MemoryMemberRepository: MemberRepository{
    var store: HashMap<Long, Member> = HashMap()
    var sequence: Long = 0L;

    override fun save(member: Member): Member {
        member.id = ++sequence
        store.put(member.id, member) // put(key, value)
        return member
    }

    override fun findById(Id: Long?): Member? {

//        return if (Id != null) store.get(Id) else null
        if(Id != null){
            return store.get(Id)
        }else{
            return null
        }
    }

    override fun findByName(name: String) : Member? {
        return store.values.find{s -> s.name == name}
    } // null 처리?

    override fun findAll(): MutableList<Member> {
        val s: MutableList<Member> = mutableListOf()
        store.values.forEach{
            s.add(it)
        }
        return s
    }

    fun clearStore() {
        store.clear()
    }

}