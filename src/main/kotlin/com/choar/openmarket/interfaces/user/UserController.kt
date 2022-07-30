package com.choar.openmarket.interfaces.user

import com.choar.openmarket.domain.user.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("user")
class UserController(
    private val userMapper: UserMapper,
    private val repository: UserRepository,
) {

    @GetMapping
    fun findAll() = userMapper.map(repository.findAll())
}
