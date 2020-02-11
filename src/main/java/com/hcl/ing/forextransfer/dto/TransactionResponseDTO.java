package com.hcl.ing.forextransfer.dto;

import java.util.Optional;

import com.hcl.ing.forextransfer.entity.Transactions;

public class TransactionResponseDTO {

	private String message;
	private Integer statusCode;
	private String status;
	
	private Optional<Transactions> transactions;
	
	public Optional<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(Optional<Transactions> transactions) {
		this.transactions = transactions;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
