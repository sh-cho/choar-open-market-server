package com.choar.openmarket.application

import com.choar.openmarket.domain.user.UserRepository
import com.choar.openmarket.interfaces.common.UserDto
import com.choar.openmarket.interfaces.user.UserMapper
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
) {

    fun findAll(): List<UserDto> {
        return userMapper.map(userRepository.findAll())
    }
}