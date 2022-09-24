package com.choar.openmarket.interfaces.user

import kotlinx.serialization.Serializable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Serializable
data class SellerSignupRequest(
    @field:NotEmpty
    @field:Pattern(regexp = "[a-zA-Z\\d]{3,20}")
    val username: String,

    @field:NotEmpty
    @field:Size(min = 8)
    val password: String,

    @field:Pattern(regexp = "010\\d{7,8}")
    val phoneNumber: String,

    @field:NotEmpty
    val name: String,
)
