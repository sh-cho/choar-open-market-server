package com.choar.openmarket.config.security

import com.choar.openmarket.interfaces.user.UserLoginRequest
import com.choar.openmarket.utils.add
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.collections.ArrayList


@EnableConfigurationProperties(JWTSecurityProperties::class)
class JWTAuthenticationFilter(
    private val authManager: AuthenticationManager,
    private val securityProperties: JWTSecurityProperties,
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {
        return try {
            val mapper = jacksonObjectMapper()

            val creds = mapper.readValue(request.inputStream, UserLoginRequest::class.java)

            authManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    creds.username,
                    creds.password,
                    ArrayList()
                )
            )
        } catch (e: IOException) {
            throw AuthenticationServiceException(e.message)
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain?,
        authResult: Authentication
    ) {
        val authClaims: MutableList<String> = mutableListOf()
        authResult.authorities?.let { authorities ->
            authorities.forEach { claim -> authClaims.add(claim.toString()) }
        }
        val token = Jwts.builder()
            .setSubject(authResult.principal as String)
            .claim("auth", authClaims)
            .setExpiration(Date().add(Calendar.DAY_OF_MONTH, securityProperties.expirationTime))
            .signWith(Keys.hmacShaKeyFor(securityProperties.secret.toByteArray()), SignatureAlgorithm.HS512)
            .compact()
        response.addHeader(securityProperties.headerString, securityProperties.tokenPrefix + token)
    }
}
