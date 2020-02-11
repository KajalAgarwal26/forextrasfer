package com.hcl.ing.forextransfer.dto;

import java.io.Serializable;

public class TransactionRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fromAccount;
	private Double fromAmount;
	private String fromCurrency; 
	private Long toAccount;
	private Double toAMount;
	private String toCurrency;
	private String description;
	
	
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
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
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getToAMount() {
		return toAMount;
	}
	public void setToAMount(Double toAMount) {
		this.toAMount = toAMount;
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
	@Override
	public String toString() {
		return "TransactionRequestDTO [fromAccount=" + fromAccount + ", fromAmount=" + fromAmount + ", fromCurrency="
				+ fromCurrency + ", toAccount=" + toAccount + ", toAMount=" + toAMount + ", toCurrency=" + toCurrency
				+ ", description=" + description + "]";
	}
	public TransactionRequestDTO(Long fromAccount, Double fromAmount, String fromCurrency, Long toAccount,
			Double toAMount, String toCurrency, String description) {
		super();
		this.fromAccount = fromAccount;
		this.fromAmount = fromAmount;
		this.fromCurrency = fromCurrency;
		this.toAccount = toAccount;
		this.toAMount = toAMount;
		this.toCurrency = toCurrency;
		this.description = description;
	}
	public TransactionRequestDTO() {
		super();
	}
	
	

}
