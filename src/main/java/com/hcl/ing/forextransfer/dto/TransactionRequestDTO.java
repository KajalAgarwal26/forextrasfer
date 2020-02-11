package com.hcl.ing.forextransfer.dto;

import java.io.Serializable;

public class TransactionRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fromAccount;
	private Long fromAmount;
	private String fromCurrency; 
	private Long toAccount;
	private Long toAMount;
	private String toCurrency;
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(Long fromAmount) {
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
	public Long getToAMount() {
		return toAMount;
	}
	public void setToAMount(Long toAMount) {
		this.toAMount = toAMount;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	@Override
	public String toString() {
		return "TransactionRequestDTO [fromAccount=" + fromAccount + ", fromAmount=" + fromAmount + ", fromCurrency="
				+ fromCurrency + ", toAccount=" + toAccount + ", toAMount=" + toAMount + ", toCurrency=" + toCurrency
				+ "]";
	}
	public TransactionRequestDTO(Long fromAccount, Long fromAmount, String fromCurrency, Long toAccount, Long toAMount,
			String toCurrency) {
		super();
		this.fromAccount = fromAccount;
		this.fromAmount = fromAmount;
		this.fromCurrency = fromCurrency;
		this.toAccount = toAccount;
		this.toAMount = toAMount;
		this.toCurrency = toCurrency;
	}
	public TransactionRequestDTO() {
		super();
	}
	
	

}
