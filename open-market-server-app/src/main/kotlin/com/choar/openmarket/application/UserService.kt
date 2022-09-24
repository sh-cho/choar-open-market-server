package com.choar.openmarket.application

import com.choar.openmarket.domain.user.User
import com.choar.openmarket.domain.user.UserRepository
import com.choar.openmarket.interfaces.common.UserDto
import com.choar.openmarket.interfaces.user.BuyerSignupRequest
import com.choar.openmarket.interfaces.user.SellerSignupRequest
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

    fun save(buyerSignupRequest: BuyerSignupRequest): User {
        return userRepository.save(userMapper.toEntity(buyerSignupRequest))
    }

    fun save(sellerSignupRequest: SellerSignupRequest): User {
        return userRepository.save(userMapper.toEntity(sellerSignupRequest))
    }
}