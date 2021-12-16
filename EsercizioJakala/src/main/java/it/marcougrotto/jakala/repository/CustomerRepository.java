package it.marcougrotto.jakala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.marcougrotto.jakala.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
