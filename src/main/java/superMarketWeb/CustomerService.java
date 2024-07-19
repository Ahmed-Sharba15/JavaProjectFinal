package superMarketWeb;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void insertCustomer(Customer customer) {
        repository.save(customer);
    }
    public void updateCustomer(Customer customer) {
        repository.save(customer);
    }
    public void deleteCustomer(long id) {
        repository.deleteById(id);
    }
   public Customer getCustomerById(long id) {
        return repository.findById(id).orElse(null);
   }
   public List<Customer> getAllCustomers(Long keyword) {
        if (keyword != null)
            return repository.search(keyword);
        return repository.findAll();
   }

}

