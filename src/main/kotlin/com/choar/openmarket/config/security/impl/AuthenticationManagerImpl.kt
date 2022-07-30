package com.choar.openmarket.config.security.impl

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthenticationManagerImpl(
    private val userService: UserDetailsService,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
): AuthenticationManager {

    override fun authenticate(authentication: Authentication): Authentication? {
        val password = authentication.credentials.toString()
        val user = userService.loadUserByUsername(authentication.name)
        if (!bCryptPasswordEncoder.matches(password, user.password)) {
            throw BadCredentialsException("Bad credentials")
        }
        return UsernamePasswordAuthenticationToken(user.username, user.password, user.authorities)
    }
}
