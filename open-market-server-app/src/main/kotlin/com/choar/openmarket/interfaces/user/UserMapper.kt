package com.choar.openmarket.interfaces.user

import com.choar.openmarket.domain.user.User
import com.choar.openmarket.interfaces.common.UserDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface UserMapper {

    fun toDto(user: User): UserDto
//    fun toDto(sellerSignupRequest: SellerSignupRequest): UserDto

    fun toEntity(userDto: UserDto): User
    fun toEntity(buyerSignupRequest: BuyerSignupRequest): User
    fun toEntity(sellerSignupRequest: SellerSignupRequest): User

    fun map(userList: List<User>): List<UserDto>

    // TODO: request DTO <-> userDto <-> Entity?
//    @Mappings(
//        @Mapping(target = ""),
//    )
//    fun sellerSignupReqToDto(sellerSignupRequest: SellerSignupRequest): UserDto

}
