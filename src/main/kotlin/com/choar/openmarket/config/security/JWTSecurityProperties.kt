package com.choar.openmarket.config.security

import org.hibernate.validator.constraints.Length
import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "jwt-security")
class JWTSecurityProperties {
    @Length(min = 42, message = "Minimum length for the secret is 42")
    var secret: String = ""

    var expirationTime: Int = 1  // in days
    var tokenPrefix: String = "Bearer "
    var headerString: String = "Authorization"
    var strength: Int = 10
}
