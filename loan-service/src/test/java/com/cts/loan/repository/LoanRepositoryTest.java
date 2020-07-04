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
	void injectedComponentsAreNotNull() {
		assertThat(loanRepository).isNotNull();
	}

	@Test
	void testAddLoanRepository() {
		loanRepository.save(expectedLoan);

		assertThat(expectedLoan.getLoanId()).isNotNull().isNotNegative();
	}

}
