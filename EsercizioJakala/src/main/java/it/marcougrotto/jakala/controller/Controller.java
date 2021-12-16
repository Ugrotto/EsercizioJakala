package it.marcougrotto.jakala.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcougrotto.jakala.model.Contract;
import it.marcougrotto.jakala.model.ContractType;
import it.marcougrotto.jakala.model.Customer;
import it.marcougrotto.jakala.model.CustomerType;
import it.marcougrotto.jakala.model.Request;
import it.marcougrotto.jakala.service.ContractService;
import it.marcougrotto.jakala.service.CustomerService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	
	@Autowired
	CustomerService customerService;
	@Autowired
	ContractService contractService;
	
	@PostMapping("/saveccustomer")
	public String saveCustomer(@RequestBody Customer customer) {
		this.customerService.saveCustomer(customer);
		return "Customer Saved";
	}
	
	@PostMapping("/savecontract")
	public String saveContract(@RequestBody Contract contract) {
		this.contractService.saveContract(contract);
		return "Contract Saved";
	}

	@GetMapping("/deletecustomer")
	public String deleteCustomer(@RequestParam Long id) {
		this.customerService.deleteCustomer(id);
		return "Customer Deleted";
	}
	
	@GetMapping("/deletecontract")
	public String deleteContract(@RequestParam Long id) {
		this.contractService.deleteContract(id);
		return "Contract Deleted";
	}
	
//	@PostMapping("/filters")
//	public ResponseEntity<?> filters (@RequestBody Request request, Pageable page){
//		if (request.getName() != null) {
//			Page<Optional<Contract>> findName=contractService.findByOrderByCustomerName(page, request.getName());
//		}
//		if (request.getContractType() != null) {
//			Page<Optional<Contract>> findContractType=contractService.findByOrderByContractType(page, request.getContractType());
//		}
//		if (request.getCustomerType() != null) {
//			Page<Optional<Contract>> findCustomerType=contractService.findByOrderByCustomerCustomerType(page, request.getCustomerType());
//		}
//		if (request.getDate() != null) {
//			Page<Optional<Contract>> findDate=contractService.findByOrderByStartingDate(page, request.getDate());
//		}
//		
//	}

	@PostMapping("/findname")
	public ResponseEntity<?> findByOrderByCustomerName(Pageable page, @RequestBody String name) {
		Page<Optional<Contract>> findName = this.contractService.findByOrderByCustomerName(page, name);
		if (findName.hasContent()) {
			return new ResponseEntity<>(findName, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/startingdate")
	public ResponseEntity<?> findByOrderByStartingDate(Pageable page,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Page<Optional<Contract>> findDate = this.contractService.findByOrderByStartingDate(page, date);
		if (findDate.hasContent()) {
			return new ResponseEntity<>(findDate, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/findcontracttype")
	public ResponseEntity<?> findByOrderByContractType(Pageable page, @RequestBody ContractType contractType) {
		Page<Optional<Contract>> find = contractService.findByOrderByContractType(page, contractType);
		if (find.hasContent()) {
			return new ResponseEntity<>(find, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/findcustomertype")
	public ResponseEntity<?> findByOrderByCustomerCustomerType(Pageable page, @RequestBody CustomerType customerType) {
		Page<Optional<Contract>> find = contractService.findByOrderByCustomerCustomerType(page, customerType);
		if (find.hasContent()) {
			return new ResponseEntity<>(find, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/findcustomer")
	public ResponseEntity<?> getByCustomer(Pageable page, @RequestBody Customer customer) {
		Page<Optional<Contract>> find = this.contractService.getByCustomer(page, customer);
		if (find.hasContent()) {
			return new ResponseEntity<>(find, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}
