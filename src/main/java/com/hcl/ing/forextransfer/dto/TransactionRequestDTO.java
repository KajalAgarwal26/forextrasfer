package com.hcl.ing.forextransfer.dto;

import java.io.Serializable;

public class TransactionRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fromAccountNumber;
	private Double fromAmount;
	private String fromCurrency; 
	private Long toAccountNumber;
	private Double toAmount;
	private String toCurrency;
	private String description;
	private Double charges;
	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public Double getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(Double fromAmount) {
		this.fromAmount = fromAmount;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public Double getToAmount() {
		return toAmount;
	}
	public void setToAmount(Double toAmount) {
		this.toAmount = toAmount;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "TransactionRequestDTO [fromAccountNumber=" + fromAccountNumber + ", fromAmount=" + fromAmount
				+ ", fromCurrency=" + fromCurrency + ", toAccountNumber=" + toAccountNumber + ", toAmount=" + toAmount
				+ ", toCurrency=" + toCurrency + ", description=" + description + ", charges=" + charges + "]";
	}
	public TransactionRequestDTO(Long fromAccountNumber, Double fromAmount, String fromCurrency, Long toAccountNumber,
			Double toAmount, String toCurrency, String description, Double charges) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.fromAmount = fromAmount;
		this.fromCurrency = fromCurrency;
		this.toAccountNumber = toAccountNumber;
		this.toAmount = toAmount;
		this.toCurrency = toCurrency;
		this.description = description;
		this.charges = charges;
	}
	public TransactionRequestDTO() {
		super();
	}
	
	
	

}
