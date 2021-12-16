package it.marcougrotto.jakala.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Request {
	
	
	private String name;
	private LocalDate date;
	private ContractType contractType;
	private CustomerType customerType;
	
	

}
