package com.cts.loan.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;

import com.cts.loan.model.Loan;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LoanRepositoryTest {

	@Autowired
	private LoanRepository loanRepository;
	private Loan expectedLoan;
	private Loan updatedLoan;
	
	private Loan expectedSearchLoanFields;
	private Loan searchedLoanFields;

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

		expectedSearchLoanFields = new Loan();
		expectedSearchLoanFields.setBorrowerName("John");
		expectedSearchLoanFields.setLoanNumber("1234A");
		expectedSearchLoanFields.setLoanAmount(1234567.0);
		
		searchedLoanFields = new Loan();
		searchedLoanFields.setBorrowerName("John");
		searchedLoanFields.setLoanNumber("1234A");
		searchedLoanFields.setLoanAmount(1234567.0);
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

	/*****************************************************************************
	The Search Loan Test Cases below is based on the following presumed data in the DB
	===========================================================
	borrower_name	|	loan_number		|	loan_amount
	===========================================================
	John			|	1234A			|	1234567.0
	Perona			|	1233A			|	1234566.0
	Perona			|	1233A			|	1234566.0
	===========================================================
	******************************************************************************/
	@Test
	void testReturnMatchingBorrowerNameAndLoanNumberAndLoanAmount(){
		

		expectedSearchLoanFields = new Loan();
		expectedSearchLoanFields.setBorrowerName("John");
		expectedSearchLoanFields.setLoanNumber("1234A");
		expectedSearchLoanFields.setLoanAmount(1234567.0);
		
		searchedLoanFields = new Loan();
		searchedLoanFields.setBorrowerName("John");
		searchedLoanFields.setLoanNumber("1234A");
		searchedLoanFields.setLoanAmount(1234567.0);
		
		//loanRepository.findAll(Example.of(SearchedLoanFields));

		//assertThat(expectedLoan.getLoanId()).isNotNull().isNotNegative();
		
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("John");
		searchLoan.setLoanNumber("1234A");
		searchLoan.setLoanAmount(1234567.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testReturnMatchingBorrowerNameAndLoanNumberAndLoanAmount :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isNotZero();
	}
	
	@Test
	void testReturnMatchingBorrowerNameAndLoanNumber(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("John");
		searchLoan.setLoanNumber("1234A");
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testReturnMatchingBorrowerNameAndLoanNumber :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isNotZero();
	}
	
	@Test
	void testReturnMatchingBorrowerNameAndLoanAmount(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("John");
		searchLoan.setLoanAmount(1234567.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testReturnMatchingBorrowerNameAndLoanAmount :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isNotZero();
	}

	@Test
	void testReturnMatchingLoanNumberAndLoanAmount(){
		Loan searchLoan=new Loan();
		searchLoan.setLoanNumber("1234A");
		searchLoan.setLoanAmount(1234567.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testReturnMatchingLoanNumberAndLoanAmount :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isNotZero();
	}
	
	@Test
	void testDoesNotReturnMatchingBorrowerNameAndLoanNumberAndLoanAmount(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("**Name**");
		searchLoan.setLoanNumber("**Loan#**");
		searchLoan.setLoanAmount(0.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnMatchingBorrowerNameAndLoanNumberAndLoanAmount :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testDoesNotReturnRecordsForWrongBorrowerNameOnly(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("Cuenca");
		searchLoan.setLoanNumber("1234A");
		searchLoan.setLoanAmount(1234567.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnRecordsForWrongBorrowerNameOnly :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testDoesNotReturnRecordsForWrongLoanNumberOnly(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("John");
		searchLoan.setLoanNumber("1234AB");
		searchLoan.setLoanAmount(1234567.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnRecordsForWrongLoanNumberOnly :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testDoesNotReturnRecordsForWrongLoanAmountOnly(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("John");
		searchLoan.setLoanNumber("1234A");
		searchLoan.setLoanAmount(123456.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnRecordsForWrongLoanAmountOnly :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testDoesNotReturnRecordsForWrongBorrowerNameAndLoanNumber(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("Johnny");
		searchLoan.setLoanNumber("1234AB");
		searchLoan.setLoanAmount(1234567.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnRecordsForWrongBorrowerNameAndLoanNumber :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testDoesNotReturnRecordsForWrongBorrowerNameAndLoanAmount(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("Johnny");
		searchLoan.setLoanNumber("1234A");
		searchLoan.setLoanAmount(123456.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnRecordsForWrongBorrowerNameAndLoanAmount :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testDoesNotReturnRecordsForWrongLoanNumberAndLoanAmount(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("John");
		searchLoan.setLoanNumber("1234AB");
		searchLoan.setLoanAmount(123456.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testDoesNotReturnRecordsForWrongLoanNumberAndLoanAmount :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isZero();
	}
	
	@Test
	void testReturnMultipleRecordsForSameBorrowerNameAndLoanNumberAndLoanAmountIfAvailableInDB(){
		Loan searchLoan=new Loan();
		searchLoan.setBorrowerName("Perona");
		searchLoan.setLoanNumber("1233A");
		searchLoan.setLoanAmount(1234566.0);
		List<Loan> loan = loanRepository.findAll(Example.of(searchLoan));
		System.out.println("testReturnMultipleRecordsForSameBorrowerNameAndLoanNumberAndLoanAmountIfAvailableInDB :: Number of matching records from Loan DB::"+loan.size());
		assertThat(loan.size()).isNotZero();
	}
	
}
