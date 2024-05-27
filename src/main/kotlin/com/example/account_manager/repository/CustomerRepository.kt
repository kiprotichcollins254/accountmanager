package com.example.account_manager.repository

import org.springframework.data.repository.Repository
import org.springframework.data.repository.JpaRepository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long>