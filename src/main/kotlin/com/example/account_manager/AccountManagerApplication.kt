package com.example.account_manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.example.account_manager.services.CustomerService
import com.example.account_manager.models.Customer
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@ComponentScan("com.example.account_manager")
class AccountManagerApplication

fun main(args: Array<String>) {
	runApplication<AccountManagerApplication>(*args)
}

@RestController
@RequestMapping("/api")
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/Customers")
    fun getAllCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping("/Customers/{id}")
    fun getCustomersById(@PathVariable("id") CustomerId: Long): Customer =
        customerService.getCustomersById(CustomerId)

    @PostMapping("/Customers")
    fun createCustomer(@RequestBody payload: Customer): Customer = customerService.createCustomer(payload)

    @PutMapping("/Customers/{id}")
    fun updateCustomerById(@PathVariable("id") CustomerId: Long, @RequestBody payload: Customer): Customer =
        customerService.updateCustomerById(CustomerId, payload)

}
