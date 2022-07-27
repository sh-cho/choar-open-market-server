package com.choar.openmarket.interfaces.common

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class TempController {
    @GetMapping("/")
    fun ok() = "ok"
}