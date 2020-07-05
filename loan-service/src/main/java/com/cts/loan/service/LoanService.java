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
		Loan loantoUpdate = getLoanByLoanId(loanId)
				.orElseThrow(() -> new NoResourceException("Loan", "loanId", String.valueOf(loanId)));
		loantoUpdate.setAddressLine1(loan.getAddressLine1());
		loantoUpdate.setAddressLine2(loan.getAddressLine2());
		loantoUpdate.setBorrowerName(loan.getBorrowerName());
		loantoUpdate.setCity(loan.getCity());
		loantoUpdate.setState(loan.getState());
		loantoUpdate.setZip(loan.getZip());
		loantoUpdate.setLienDescription(loan.getLienDescription());
		loantoUpdate.setLienID(loan.getLienID());
		loantoUpdate.setLienType(loan.getLienType());
		loantoUpdate.setLoanAmount(loan.getLoanAmount());
		loantoUpdate.setLoanTerm(loan.getLoanTerm());

		return repository.save(loantoUpdate);
	}

	private Optional<Loan> getLoanByLoanId(int loanId) {
		return repository.findById(loanId);

	}

}
