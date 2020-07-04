package com.cts.loan.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.loan.model.Loan;
import com.cts.loan.repository.LoanRepository;


class LoanServiceTest {

	@Mock
	private LoanRepository loanRepository;
	
	private Loan expectedLoan;
	
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

	}

	@Test
	void testAddLoan_Success() {

		when(loanRepository.save((Loan) any())).thenReturn(expectedLoan);
		Assertions.assertEquals(expectedLoan, loanService.addLoan(expectedLoan));
	}
}
