package it.marcougrotto.jakala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.marcougrotto.jakala.model.Customer;
import it.marcougrotto.jakala.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public void saveCustomer(Customer customer) {
		this.customerRepo.save(customer);
	}

	public void deleteCustomer(Long id) {
		this.customerRepo.deleteById(id);
	}

}
