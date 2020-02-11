package com.hcl.ing.forextransfer.dto;

import java.util.List;

import com.hcl.ing.forextransfer.entity.Transactions;

public class TransactionResponseDTO {

	private String message;
	private Integer statusCode;
	private String status;
	
	private List<Transactions> transactions;
	
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
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
