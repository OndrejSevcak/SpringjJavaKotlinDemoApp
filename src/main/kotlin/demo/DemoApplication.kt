package com.example.demo.kotlin

import org.apache.catalina.core.ApplicationContext
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DemoApplication {

    @Bean
    fun commandLineRunner(ctx: ApplicationContext) = CommandLineRunner {
        println("Bla bla inspect beans from kontlin")
    }
}
