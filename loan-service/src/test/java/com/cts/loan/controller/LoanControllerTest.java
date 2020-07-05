package com.cts.loan.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.loan.model.Loan;
import com.cts.loan.service.LoanService;
import com.cts.loan.exception.NoResourceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
class LoanControllerTest {

	@InjectMocks
	private LoanController loanController;

	@MockBean
	private LoanService loanService;

	private Loan expectedLoan;

	private Loan updatedLoan;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();

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
	void testAddLoan_Success() throws Exception {

		when(loanService.addLoan((Loan) any())).thenReturn(expectedLoan);
		mockMvc.perform(post("/api/v1/loan/addLoan").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(expectedLoan))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testIncorrectRoute_Failure() throws Exception {

		when(loanService.addLoan((Loan) any())).thenReturn(expectedLoan);
		mockMvc.perform(post("/api/v1/loan/fakeAddLoan").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(expectedLoan))).andExpect(status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testUpdateLoan_Success() throws Exception {

		when(loanService.updateLoan(anyInt(), (Loan) any())).thenReturn(updatedLoan);
		mockMvc.perform(post("/api/v1/loan/updateLoan/2").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(updatedLoan))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testUpdateLoan_Failure() throws Exception {

		when(loanService.updateLoan(anyInt(), (Loan) any()))
				.thenThrow(new NoResourceException("Loan", "loanId", String.valueOf(updatedLoan.getLoanId())));
		mockMvc.perform(post("/api/v1/loan/updateLoan/0").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(updatedLoan))).andExpect(status().isInternalServerError())
				.andDo(MockMvcResultHandlers.print());
	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
