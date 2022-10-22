package com.choar.openmarket.interfaces.user

import kotlinx.serialization.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Serializable
data class BuyerSignupRequest(
    @field:NotEmpty
    @field:Pattern(regexp = "\\w{3,20}")
    override val username: String,

    @field:NotEmpty
    @field:Size(min = 8)
    override val password: String,

    @field:Email
    override val email: String,

    @field:Pattern(regexp = "010\\d{7,8}")
    override val phoneNumber: String,

    @field:NotEmpty
    override val name: String,
) : AbstractSignupRequest()
