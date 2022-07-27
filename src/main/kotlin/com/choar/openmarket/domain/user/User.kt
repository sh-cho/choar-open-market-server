package com.choar.openmarket.domain.user

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    var username: String,
    var password: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (username != other.username) return false
        if (id != other.id) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}
