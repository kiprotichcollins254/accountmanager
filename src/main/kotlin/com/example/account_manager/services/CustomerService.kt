package com.example.account_manager.services

import com.example.account_manager.repository.CustomerRepository
import com.example.account_manager.models.Customer

@Service
class CustomerService(private val CustomerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> = CustomerRepository.findAll()

    fun getCustomersById(CustomerId: Long): Customer = CustomerRepository.findById(CustomerId)
            .orElseThrow { NotFoundException(HttpStatus.NOT_FOUND, "No matching Customer was found") }

    fun createCustomer(Customer: Customer): Customer = CustomerRepository.save(Customer)

    fun updateCustomerById(CustomerId: Long, Customer: Customer): Customer {
        return if (CustomerRepository.existsById(CustomerId)) {
            CustomerRepository.save(
                    Customer(
                            id = Customer.id,
                            fullNames = Customer.fullNames,
                            accNo = Customer.accNo,
                            emailAddress = Customer.emailAddress,
                            avalBal = Customer.avalBal
                    )
            )
        } else throw NotFoundException(HttpStatus.NOT_FOUND, "No matching Customer was found")
    }

    fun deleteCustomersById(CustomerId: Long) {
        return if (CustomerRepository.existsById(CustomerId)) {
            CustomerRepository.deleteById(CustomerId)
        } else throw NotFoundException(HttpStatus.NOT_FOUND, "No matching Customer was found")
    }
}