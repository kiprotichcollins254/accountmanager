@Service
class CustomerService(private val CustomerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> = CustomerRepository.findAll()

    fun getCustomersById(CustomerId: Long): Customer = CustomerRepository.findById(CustomerId)
            .orElseThrow { CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching Customer was found") }

    fun createCustomer(Customer: Customer): Customer = CustomerRepository.save(Customer)

    fun updateCustomerById(CustomerId: Long, Customer: Customer): Customer {
        return if (CustomerRepository.existsById(CustomerId)) {
            CustomerRepository.save(
                    Customer(
                            id = Customer.id,
                            full_names = Customer.fullNames,
                            emailAddress = Customer.emailAddress,
                            avalBal = Customer.avalBal
                    )
            )
        } else throw CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching Customer was found")
    }

    fun deleteCustomersById(CustomerId: Long) {
        return if (CustomerRepository.existsById(CustomerId)) {
            CustomerRepository.deleteById(CustomerId)
        } else throw CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching Customer was found")
    }
}