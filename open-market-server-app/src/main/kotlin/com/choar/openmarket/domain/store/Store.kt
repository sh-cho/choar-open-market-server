package com.choar.openmarket.domain.store

import javax.persistence.*

@Entity
@Table(name = "stores")
class Store(
    @Column(unique = true)
    var name: String,

    @Column
    var businessRegistrationNumber: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    // TODO: auto generate equals, hashcode?
    // data class는 {} 내부 프로퍼티는 여기에 포함 안됨
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Store

        if (name != other.name) return false
        if (businessRegistrationNumber != other.businessRegistrationNumber) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + businessRegistrationNumber.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }
}
