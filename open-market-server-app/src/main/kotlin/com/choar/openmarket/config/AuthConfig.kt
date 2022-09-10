package com.choar.openmarket.config

import com.choar.openmarket.config.security.JWTSecurityProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(JWTSecurityProperties::class)
class AuthConfig(
    private val securityProperties: JWTSecurityProperties,
) {
    @Bean
    fun bCryptPasswordEncoder() = BCryptPasswordEncoder(securityProperties.strength)
}