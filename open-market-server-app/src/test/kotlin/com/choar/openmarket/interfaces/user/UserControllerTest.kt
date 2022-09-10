package com.choar.openmarket.interfaces.user

import com.choar.openmarket.application.UserService
import com.choar.openmarket.config.RestDocsConfiguration
import com.choar.openmarket.interfaces.common.UserDto
import org.json.JSONObject
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.restdocs.headers.HeaderDocumentation.*
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@SpringBootTest
@Import(RestDocsConfiguration::class)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
internal class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var userService: UserService

    @BeforeEach
    internal fun setUp() {
        given(userService.findAll()).willReturn(
            listOf(
                UserDto("admin"),
                UserDto("buyer1"),
            )
        )
    }

    @Test
    @DisplayName("로그인 테스트")
    fun login() {
        val loginRequest = JSONObject()
        loginRequest.put("username", "buyer1")
        loginRequest.put("password", "hodu0910")

        mockMvc.perform(
            post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest.toString())
        )
            .andExpect(status().isOk)
            .andExpect(header().exists("Authorization"))
            .andDo(
                document(
                    "users/login",
                    requestFields(
                        fieldWithPath("username").description("유저명"),
                        fieldWithPath("password").description("비밀번호"),
                    ),
                    responseHeaders(
                        headerWithName("Authorization").description("Bearer Token (JWT)")
                    ),
                )
            )
    }
}