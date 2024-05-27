package com.example.account_manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.boot.runApplication

@SpringBootApplication
class AccountManagerApplication

fun main(args: Array<String>) {
	runApplication<AccountManagerApplication>(*args)
}

@RestController
class CustomerController(private val CustomerService: CustomerService) {

    @GetMapping("/Customers")
    fun getAllCustomers(): List<Customer> = CustomerService.getAllCustomers()

    @GetMapping("/Customers/{id}")
    fun getCustomersById(@PathVariable("id") CustomerId: Long): Customer =
            CustomerService.getCustomersById(CustomerId)

    @PostMapping("/Customers")
    fun createCustomer(@RequestBody payload: Customer): Customer = CustomerService.createCustomer(payload)

    @PutMapping("/Customers/{id}")
    fun updateCustomerById(@PathVariable("id") CustomerId: Long, @RequestBody payload: Customer): Customer =
            CustomerService.updateCustomerById(CustomerId, payload)

}
