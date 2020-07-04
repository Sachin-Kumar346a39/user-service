package com.cts.loan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.loan.exception.NoResourceException;
import com.cts.loan.model.Loan;
import com.cts.loan.service.LoanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping("/addLoan")
	public ResponseEntity<Loan> addLoan(@Valid @RequestBody Loan loan) {

		HttpStatus status = HttpStatus.OK;
		Loan lLoan = null;

		try {
			lLoan = loanService.addLoan(loan);
		} catch (NoResourceException e) {
			log.error("LoanController Exception: ", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Loan>(lLoan, status);
	}

}
