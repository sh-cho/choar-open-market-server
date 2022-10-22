package com.choar.openmarket.interfaces.user

abstract class AbstractSignupRequest {
    abstract val username: String
    abstract val password: String
    abstract val email: String
    abstract val phoneNumber: String
    abstract val name: String
}
