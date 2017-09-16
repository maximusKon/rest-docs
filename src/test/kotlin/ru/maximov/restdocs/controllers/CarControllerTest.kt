package ru.maximov.restdocs.controllers

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import ru.maximov.restdocs.config.Application
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@ContextConfiguration(classes = arrayOf(Application::class))
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@SpringBootTest
class CarControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getCar() {
        mockMvc.perform(get("/getCar/1"))
                .andExpect(status().isOk)
    }

}