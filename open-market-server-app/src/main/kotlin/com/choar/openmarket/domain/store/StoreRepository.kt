package com.choar.openmarket.domain.store

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long> {
    // TODO: use ES instead of rdb
    //  + throttling
    fun findStoreByNameContainingIgnoreCase(name: String): Store?
}
