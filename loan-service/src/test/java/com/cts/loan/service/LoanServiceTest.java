package com.cts.loan.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.loan.exception.NoResourceException;
import com.cts.loan.model.Loan;
import com.cts.loan.repository.LoanRepository;

class LoanServiceTest {

	@Mock
	private LoanRepository loanRepository;

	private Loan expectedLoan;
	private Loan updatedLoan;

	@InjectMocks
	private LoanService loanService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		expectedLoan = new Loan();
		expectedLoan.setBorrowerName("Borrower 1");
		expectedLoan.setAddressLine1("202 HARTNELL");
		expectedLoan.setAddressLine2("PL");
		expectedLoan.setCity("Sacramento");
		expectedLoan.setState("CA");
		expectedLoan.setZip(97978);
		expectedLoan.setLoanNumber("001");
		expectedLoan.setLoanAmount(10000.0);
		expectedLoan.setLoanTerm((float) 5);
		expectedLoan.setLienType("SALE");
		expectedLoan.setLienID("001");
		expectedLoan.setLienDescription("LIEN");

		updatedLoan = new Loan();
		updatedLoan.setLoanId(1);
		updatedLoan.setBorrowerName("Borrower 1");
		updatedLoan.setAddressLine1("202 HARTNELL");
		updatedLoan.setAddressLine2("PL");
		updatedLoan.setCity("Sacramento");
		updatedLoan.setState("CA");
		updatedLoan.setZip(97978);
		updatedLoan.setLoanNumber("001");
		updatedLoan.setLoanAmount(10000.0);
		updatedLoan.setLoanTerm((float) 5);
		updatedLoan.setLienType("SALE");
		updatedLoan.setLienID("001");
		updatedLoan.setLienDescription("LIEN");

	}

	@Test
	void testAddLoan_Success() {

		when(loanRepository.save((Loan) any())).thenReturn(expectedLoan);
		Assertions.assertEquals(expectedLoan, loanService.addLoan(expectedLoan));
	}

	@Test
	void testUpdateLoan_Success() {

		when(loanRepository.save((Loan) any())).thenReturn(updatedLoan);
		when(loanRepository.findById(anyInt())).thenReturn(Optional.of(updatedLoan));
		Assertions.assertEquals(updatedLoan, loanService.updateLoan(1, updatedLoan));
	}

	@Test
	void testUpdateLoan_Failure() {

		when(loanRepository.save((Loan) any())).thenThrow(NoResourceException.class);
		
		assertThatThrownBy(() -> loanService.updateLoan(updatedLoan.getLoanId(), updatedLoan))
				.isInstanceOf(NoResourceException.class)
				.hasMessage("Loan Not found with loanId: " + updatedLoan.getLoanId()).hasNoCause();
	}
}
