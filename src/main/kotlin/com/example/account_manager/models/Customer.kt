package com.example.account_manager.models

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Entity
import org.springframework.data.annotation.GeneratedValue
import org.springframework.data.annotation.GenerationType
import org.springframework.data.annotation.Column
import org.springframework.data.relational.core.mapping.Table

@Entity
@Table(name = "customer")

data class Customer (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column(name = "full_names", nullable = false)
        val fullNames: String,
        @Column(name = "email_address", nullable = false)
        val emailAddress: String,
        @Column(name = "avl_bal", nullable = false)
        val avalBal: Boolean
)