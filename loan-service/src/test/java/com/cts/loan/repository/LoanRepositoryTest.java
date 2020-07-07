package com.cts.loan.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.loan.model.Loan;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LoanRepositoryTest {

	@Autowired
	private LoanRepository loanRepository;
	private Loan expectedLoan;
	private Loan updatedLoan;

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
		expectedLoan.setLegalDescription("LIEN");

		updatedLoan = new Loan();
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
		updatedLoan.setLegalDescription("LIEN");

	}

	@Test
	void injectedComponentsAreNotNull() {
		assertThat(loanRepository).isNotNull();
	}

	@Test
	void testAddLoanRepository() {
		loanRepository.save(expectedLoan);

		assertThat(expectedLoan.getLoanId()).isNotNull().isNotNegative();
	}

	@Test
	void testUpdateLoanRepository() {
		loanRepository.save(updatedLoan);

		assertThat(updatedLoan.getLoanId()).isNotNull().isNotNegative();
	}

}
