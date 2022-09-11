package com.choar.openmarket.helper

import org.springframework.restdocs.constraints.ConstraintDescriptions
import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.snippet.Attributes.key

class ConstrainedFields(clazz: Class<*>) {
    private val constraintDescriptions = ConstraintDescriptions(clazz)

    fun withPath(path: String): FieldDescriptor = fieldWithPath(path).attributes(
        key("constraints").value(
            this.constraintDescriptions.descriptionsForProperty(path)
                .joinToString(separator = "\n\n") { "- $it" }
        )
    )
}