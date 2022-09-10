package com.choar.openmarket.config.security.impl

import com.choar.openmarket.config.security.UserAccount
import com.choar.openmarket.domain.user.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl(
    private val userRepository: UserRepository,
) : UserDetailsService {

    override fun loadUserByUsername(s: String): UserDetails {
        val user = userRepository.findByUsername(s)
            ?: throw UsernameNotFoundException("The username $s doesn't exist")

        val authorities = ArrayList<GrantedAuthority>()
        user.roles.forEach { authorities.add(SimpleGrantedAuthority(it.roleName)) }

        return UserAccount(user, authorities)
    }
}