package com.cts.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.loan.model.Loan;
import com.cts.loan.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository repository;
	
	public Loan addLoan(Loan loan) {
		Loan lLoan = repository.save(loan);
		return lLoan;
	}

}
