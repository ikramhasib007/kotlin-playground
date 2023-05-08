package com.kotlinspring.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class GreetingControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun retrieveGreeting() {
        val name = "Hasib"
        val result = webTestClient.get()
            .uri("/v1/greetings/{name}", name)
            .exchange() // actual API call
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java) // body assertion in kotlin
            .returnResult()

        Assertions.assertEquals("$name, Hello from default profile", result.responseBody)

    }
    

}