package com.example.account_manager.services

import com.example.account_manager.repository.CustomerRepository
import com.example.account_manager.models.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService @Autowired constructor(private val  db: CustomerRepository){



    fun getAllCustomers(): List<Customer> = db.findAll().toList()

    fun getCustomersById(CustomerId: Long): Customer = db.findById(CustomerId)
            .orElseThrow {
                ChangeSetPersister.NotFoundException(
                )
            }

    fun createCustomer(Customer: Customer): Customer = db.save(Customer)

    fun updateCustomerById(CustomerId: Long, Customer: Customer): Customer {
        return if (db.existsById(CustomerId)) {
            db.save(
                    Customer(
                            id = Customer.id,
                            fullNames = Customer.fullNames,
                            accNo = Customer.accNo,
                            emailAddress = Customer.emailAddress,
                            avalBal = Customer.avalBal
                    )
            )
        } else throw ChangeSetPersister.NotFoundException()
    }

    fun deleteCustomersById(CustomerId: Long) {
        return if (db.existsById(CustomerId)) {
            db.deleteById(CustomerId)
        } else throw ChangeSetPersister.NotFoundException()
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}