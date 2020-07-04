package com.cts.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Integer loanId;

	@NotNull
	@Column(name = "borrower_name")
	private String borrowerName;

	@NotNull
	@Column(name = "address_line_1")
	private String addressLine1;

	@NotNull
	@Column(name = "address_line_2")
	private String addressLine2;

	@NotNull
	@Column(name = "city")
	private String city;

	@NotNull
	@Column(name = "zip")
	private Integer zip;

	@NotNull
	@Column(name = "state")
	private String state;

	@NotNull
	@Column(name = "loan_number")
	private String loanNumber;

	@NotNull
	@Column(name = "loan_amount")
	private Double loanAmount;

	@NotNull
	@Column(name = "loan_term")
	private Float loanTerm;

	@NotNull
	@Column(name = "lien_id")
	private String lienID;

	@NotNull
	@Column(name = "lien_type")
	private String lienType;

	@NotNull
	@Column(name = "lien_description")
	private String lienDescription;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Float getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(Float loanTerm) {
		this.loanTerm = loanTerm;
	}

	public String getLienID() {
		return lienID;
	}

	public void setLienID(String lienID) {
		this.lienID = lienID;
	}

	public String getLienType() {
		return lienType;
	}

	public void setLienType(String lienType) {
		this.lienType = lienType;
	}

	public String getLienDescription() {
		return lienDescription;
	}

	public void setLienDescription(String lienDescription) {
		this.lienDescription = lienDescription;
	}
}
