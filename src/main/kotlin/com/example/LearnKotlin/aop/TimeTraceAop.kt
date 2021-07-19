package com.example.LearnKotlin.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

// component -> spring bin 등록
@Aspect
@Component
class TimeTraceAop {


    @Around("execution(* com.example.LearnKotlin..*(..))")
    fun excute(joinPoint: ProceedingJoinPoint): Any{

        val start: Long = System.currentTimeMillis()
        println("START: " + joinPoint.toString())

        try{
            return joinPoint.proceed()
        }finally{
            val finish: Long = System.currentTimeMillis()
            val timeMs: Long = finish - start;
            println("END: " + joinPoint.toString() + " " + timeMs + "ms")
        }
    }
}