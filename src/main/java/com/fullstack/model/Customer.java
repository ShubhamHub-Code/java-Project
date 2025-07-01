package com.fullstack.model;

public class Customer {

	private long custAccountNumber;

	private String custName;

	private String custAddress;

	private double custAccountBalance;

	private long custContactNumber;

	private String custEmailId;

	private String custPassword;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(long custAccountNumber, String custName, String custAddress, double custAccountBalance,
			long custContactNumber, String custEmailId, String custPassword) {
		super();
		this.custAccountNumber = custAccountNumber;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custAccountBalance = custAccountBalance;
		this.custContactNumber = custContactNumber;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
	}

	public long getCustAccountNumber() {
		return custAccountNumber;
	}

	public void setCustAccountNumber(long custAccountNumber) {
		this.custAccountNumber = custAccountNumber;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public double getCustAccountBalance() {
		return custAccountBalance;
	}

	public void setCustAccountBalance(double custAccountBalance) {
		this.custAccountBalance = custAccountBalance;
	}

	public long getCustContactNumber() {
		return custContactNumber;
	}

	public void setCustContactNumber(long custContactNumber) {
		this.custContactNumber = custContactNumber;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "Customer [custAccountNumber=" + custAccountNumber + ", custName=" + custName + ", custAddress="
				+ custAddress + ", custAccountBalance=" + custAccountBalance + ", custContactNumber="
				+ custContactNumber + ", custEmailId=" + custEmailId + ", custPassword=" + custPassword + "]";
	}

}
