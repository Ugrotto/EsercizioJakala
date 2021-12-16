package it.marcougrotto.jakala.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.marcougrotto.jakala.model.Contract;
import it.marcougrotto.jakala.model.ContractType;
import it.marcougrotto.jakala.model.Customer;
import it.marcougrotto.jakala.model.CustomerType;

public interface ContractRepository extends JpaRepository<Contract, Long> {

	Page<Optional<Contract>> findByOrderByCustomerName(Pageable pageable, String name);

	Page<Optional<Contract>> findByOrderByStartingDate(Pageable pageable, LocalDate date);

	Page<Optional<Contract>> findByOrderByContractType(Pageable pageable, ContractType contract);

	Page<Optional<Contract>> findByOrderByCustomerCustomerType(Pageable pageable, CustomerType customerType);

	@Query("SELECT c.customer.contracts FROM Contract c WHERE c.customer=:customer")
	Page<Optional<Contract>> getByCustomer(Pageable pageable, Customer customer);
	
//	Page<Optional<Contract>> findByOrderByCustomer(Pageable pageable, Customer customer);

}
