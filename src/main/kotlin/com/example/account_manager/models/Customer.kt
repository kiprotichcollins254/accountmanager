package com.example.account_manager.models

import jakarta.persistence.*
import org.springframework.data.annotation.Id


@Entity
//@Table(name = "customer")

data class Customer (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column(name = "full_names", nullable = false)
        val fullNames: String,
        @Column(name = "account_number", nullable = false)
        val accNo: String,
        @Column(name = "email_address", nullable = false)
        val emailAddress: String,
        @Column(name = "aval_bal", nullable = false)
        val avalBal: Boolean
)