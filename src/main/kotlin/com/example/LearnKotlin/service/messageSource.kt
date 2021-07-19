package com.example.LearnKotlin.service

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Component

@Component
class messageClass {

    @Bean
    fun messageSourceFun(): MessageSource {
        var source: ResourceBundleMessageSource = ResourceBundleMessageSource()
        source.addBasenames("messages")
        source.setDefaultEncoding("UTF-8")

        return source
    }

}


