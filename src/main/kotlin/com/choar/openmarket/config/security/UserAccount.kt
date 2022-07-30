package com.choar.openmarket.config.security

import com.choar.openmarket.domain.user.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User as UserDetailsUser


class UserAccount(
    user: User,
    authorities: Collection<GrantedAuthority>,
) : UserDetailsUser(
    user.username,
    user.password,
    authorities,
)