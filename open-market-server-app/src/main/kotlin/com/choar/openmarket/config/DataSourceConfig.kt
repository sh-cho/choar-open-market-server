package com.choar.openmarket.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DataSourceConfig {

    val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun postgresDatasource(
        @Value("\${spring.datasource.driver-class-name}") dbDriverClassName: String,
        @Value("\${spring.datasource.url}") url: String,
        @Value("\${spring.datasource.username}") username: String,
        @Value("\${spring.datasource.password}") password: String,
    ): DataSource {
        return DataSourceBuilder.create()
            .driverClassName(dbDriverClassName)
            .url(url)
            .username(username)
            .password(password)
            .build()
    }
}