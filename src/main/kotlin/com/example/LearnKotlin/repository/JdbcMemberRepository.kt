package com.example.LearnKotlin.repository

import com.example.LearnKotlin.domain.Member
import java.sql.Connection
import javax.sql.DataSource
import javax.xml.crypto.Data

//class JdbcMemberRepository: MemberRepository
class JdbcMemberRepository {
    var empty: String = "hey"
//    var datasource: DataSource = DataSource
//
//    fun JdbeMemberRepository(dataSource: DataSource) {
//        this.datasource = datasource
//    }
//
//    override fun save(member: Member): Member {
//        var sql: String = "insert into member(name) values(?)"
//
//        var connection: Connection = datasource.getConnection()
//        connection.prepareStatement(sql)
//        return null
//    }
}