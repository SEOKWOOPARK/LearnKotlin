package com.example.LearnKotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class AnnoClass @Autowired constructor(HashInput: HashMap<Int, String>){
    var HashInput:HashMap<Int, String> = HashInput

    fun HashReturnFun(): HashMap<Int, String> {
        HashInput.put(1, "kane")
        HashInput.put(2, "Salah")
        return HashInput
    }

//    @Component
//    fun ListReturnFun(StringInput: String): String {
//        return ListInput
//    }


}