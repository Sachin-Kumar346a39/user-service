package com.cts.loan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.loan.exception.NoResourceException;
import com.cts.loan.model.Loan;
import com.cts.loan.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;

	public Loan addLoan(Loan loan) {

		return repository.save(loan);
	}

	public Loan updateLoan(int loanId, Loan loan) {
		Loan loanToUpdate = getLoanByLoanId(loanId)
				.orElseThrow(() -> new NoResourceException("Loan", "loanId", String.valueOf(loanId)));
		loanToUpdate.setAddressLine1(loan.getAddressLine1());
		loanToUpdate.setAddressLine2(loan.getAddressLine2());
		loanToUpdate.setBorrowerName(loan.getBorrowerName());
		loanToUpdate.setCity(loan.getCity());
		loanToUpdate.setState(loan.getState());
		loanToUpdate.setZip(loan.getZip());
		loanToUpdate.setLegalDescription(loan.getLegalDescription());
		loanToUpdate.setLienID(loan.getLienID());
		loanToUpdate.setLienType(loan.getLienType());
		loanToUpdate.setLoanAmount(loan.getLoanAmount());
		loanToUpdate.setLoanTerm(loan.getLoanTerm());

		return repository.save(loanToUpdate);
	}

	private Optional<Loan> getLoanByLoanId(int loanId) {
		return repository.findById(loanId);

	}

}
