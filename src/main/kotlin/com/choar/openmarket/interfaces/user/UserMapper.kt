package com.choar.openmarket.interfaces.user

import com.choar.openmarket.domain.user.User
import com.choar.openmarket.interfaces.common.UserDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface UserMapper {

    fun toDto(user: User): UserDto
    fun toEntity(userDto: UserDto): User
    fun map(userList: List<User>): List<UserDto>
}
