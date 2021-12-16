package it.marcougrotto.jakala.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.marcougrotto.jakala.model.Contract;
import it.marcougrotto.jakala.model.ContractType;
import it.marcougrotto.jakala.model.Customer;
import it.marcougrotto.jakala.model.CustomerType;
import it.marcougrotto.jakala.repository.ContractRepository;

@Service
public class ContractService {
	
	@Autowired
	ContractRepository contractRepo;
	
	public void saveContract(Contract contract) {
		this.contractRepo.save(contract);
	}

	public void deleteContract(Long id) {
		this.contractRepo.deleteById(id);
	}
	
	public Page<Optional<Contract>> findByOrderByCustomerName(Pageable page, String name){
		return this.contractRepo.findByOrderByCustomerName(page, name);
	}
	
	public Page<Optional<Contract>> findByOrderByStartingDate(Pageable page, LocalDate date){
		return this.contractRepo.findByOrderByStartingDate(page, date);
	}
	
	public Page<Optional<Contract>> findByOrderByContractType(Pageable page, ContractType contract){
		return this.contractRepo.findByOrderByContractType(page, contract);
	}
	
	public Page<Optional<Contract>> findByOrderByCustomerCustomerType(Pageable page, CustomerType customerType){
		return this.contractRepo.findByOrderByCustomerCustomerType(page, customerType);
	}
	
	public Page<Optional<Contract>> getByCustomer(Pageable page, Customer customer){
		return this.contractRepo.getByCustomer(page, customer);
	}
}
