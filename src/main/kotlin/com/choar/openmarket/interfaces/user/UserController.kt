package com.choar.openmarket.interfaces.user

import com.choar.openmarket.application.UserService
import com.choar.openmarket.interfaces.common.UserDto
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("user")
class UserController(
    private val userService: UserService,
) {

    // TODO: @AuthenticationPrincipal 로 정보 들고오기?
    // (참고 - https://bbbicb.tistory.com/48)
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    fun findAll(): List<UserDto> = userService.findAll()
}
