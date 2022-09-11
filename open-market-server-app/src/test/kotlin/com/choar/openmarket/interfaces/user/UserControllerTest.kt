package com.choar.openmarket.interfaces.user

import com.choar.openmarket.application.UserService
import com.choar.openmarket.config.RestDocsConfiguration
import com.choar.openmarket.helper.ConstrainedFields
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.json.JSONObject
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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
//        given(userService.findAll()).willReturn(
//            listOf(
//                UserDto("buyer1"),
//                UserDto("buyer2"),
//                UserDto("buyer3"),
//            )
//        )
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

    @Test
    @DisplayName("구매자 회원가입")
    fun signUpBuyer() {
        val buyerSignupRequest = BuyerSignupRequest(
            "vince_test",
            "password123",
            "01012341234",
            "빈스",
        )

        val fields = ConstrainedFields(BuyerSignupRequest::class.java)

        mockMvc.perform(
            post("/user/signup/buyer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Json.encodeToString(buyerSignupRequest))
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "users/signup-buyer",
                    requestFields(
                        fields.withPath("username").description("유저명 (아이디)"),
                        fields.withPath("password").description("패스워드"),
                        fields.withPath("phoneNumber").description("핸드폰 번호"),
                        fields.withPath("name").description("이름"),
                    ),
                )
            )
    }
}