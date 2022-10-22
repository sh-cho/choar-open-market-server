package com.choar.openmarket.domain.user

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Column(unique = true)
    var username: String,

    @Column
    var password: String,

    @Column
    var roleName: String,

    @Column(unique = true)
    var email: String,

    @Column
    var phoneNumber: String?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (username != other.username) return false
        if (password != other.password) return false
        if (roleName != other.roleName) return false
        if (phoneNumber != other.phoneNumber) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + roleName.hashCode()
        result = 31 * result + (phoneNumber?.hashCode() ?: 0)
        result = 31 * result + id.hashCode()
        return result
    }
}
