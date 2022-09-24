package com.choar.openmarket.interfaces.user

import com.choar.openmarket.application.UserService
import com.choar.openmarket.interfaces.common.UserDto
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("users")
class UserController(
    private val userService: UserService,
) {

    val logger = LoggerFactory.getLogger(javaClass)

    // TODO: @AuthenticationPrincipal 로 정보 들고오기?
    // (참고 - https://bbbicb.tistory.com/48)
    // 테스트용 엔드포인트
    @GetMapping
    @PreAuthorize("hasAnyAuthority('BUYER', 'SELLER')")
    fun findAll(): List<UserDto> = userService.findAll()

    @PostMapping("signup/buyer")
    fun signUpBuyer(@RequestBody @Valid buyerSignupRequest: BuyerSignupRequest): ResponseEntity<Void> {
        logger.info(buyerSignupRequest.toString())

        return try {
            userService.save(buyerSignupRequest)
            ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            logger.warn(e.message)
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
