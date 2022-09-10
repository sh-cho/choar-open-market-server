package com.choar.openmarket.domain.user

import javax.persistence.*

@Entity
@Table(name = "roles")
class Role(
    @Column
    var roleName: String,

    @Column
    var description: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToMany(mappedBy = "roles")
    val users: MutableSet<User> = mutableSetOf()
}