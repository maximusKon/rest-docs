package ru.maximov.restdocs.controllers

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import ru.maximov.restdocs.config.Application


@RunWith(SpringRunner::class)
@ContextConfiguration(classes = arrayOf(Application::class))
@WebAppConfiguration
@SpringBootTest
class CarControllerTest {

    @get:Rule
    var restDocumentation = JUnitRestDocumentation()

    @Autowired
    private val context: WebApplicationContext? = null

    private var mockMvc: MockMvc? = null

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply<DefaultMockMvcBuilder>(documentationConfiguration(this.restDocumentation))
                .build()
    }

    @Test
    fun getCar() {
        mockMvc!!.perform(get("/getCar/1"))
                .andExpect(status().isOk)
                .andDo(document("index",
                        responseFields(
                                fieldWithPath("id").description("Идентификатор"),
                                fieldWithPath("brand").description("Марка машины")
                        ))
                )
    }

}