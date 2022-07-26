package com.choar.openmarket.controller

import com.choar.openmarket.domain.User
import com.choar.openmarket.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController(
    private val repository: UserRepository,
) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @PostMapping
    fun login(@RequestBody user: User) =
        repository.findByUsername(user.username) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "noo!")
}