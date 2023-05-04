package com.kotlinspring.controller

import com.kotlinspring.service.GreetingsService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [GreetingController::class])
class GreetingControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var greetingsServiceMock: GreetingsService

    @Test
    fun retrieveGreeting() {

        val name = "Hasib"

        // mocking "greetingsServiceMock.retrieveGreeting"
        every { greetingsServiceMock.retrieveGreeting(any()) } returns "$name, Hello from default profile"

        val result = webTestClient.get()
            .uri("/v1/greetings/{name}", name)
            .exchange() // actual API call
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java) // body assertion in kotlin
            .returnResult()

        Assertions.assertEquals("$name, Hello from default profile", result.responseBody)

    }

}