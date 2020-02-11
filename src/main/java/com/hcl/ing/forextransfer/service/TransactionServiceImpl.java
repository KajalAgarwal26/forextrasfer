package com.hcl.ing.forextransfer.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.entity.Transactions;
import com.hcl.ing.forextransfer.exception.InvalidAccountNumber;
import com.hcl.ing.forextransfer.repository.AccountRepository;
import com.hcl.ing.forextransfer.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public TransactionResponseDTO confirmTransaction(TransactionRequestDTO transferRequestDTO) {
		TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();

		Transactions fromTransactions = new Transactions();
		Optional<Accounts> fromAccountDetails = getAccountByID(transferRequestDTO.getFromAccountNumber());
		if (!fromAccountDetails.isPresent()) {
			throw new InvalidAccountNumber(transferRequestDTO.getFromAccountNumber() + " is not available");
		} else {
			fromTransactions.setUserId(fromAccountDetails.get().getUserId());
			fromTransactions.setAccountNumber(transferRequestDTO.getFromAccountNumber());
			Double fromAmount = transferRequestDTO.getFromAmount();
			Double charges = transferRequestDTO.getCharges();
			fromTransactions.setAmount(fromAmount + charges);
			fromTransactions.setCurrency(transferRequestDTO.getFromCurrency());
			fromTransactions.setDescription(transferRequestDTO.getDescription());
			fromTransactions.setTransactionType("DEBIT");
			fromTransactions.setStatus("Pending");
			fromTransactions.setTransactionDate(LocalDateTime.now().toString());
			transactionRepository.save(fromTransactions);
		}
		Transactions toTransactions = new Transactions();
		Optional<Accounts> toAccountDetails = getAccountByID(transferRequestDTO.getToAccountNumber());
		if (!toAccountDetails.isPresent()) {
			throw new InvalidAccountNumber(transferRequestDTO.getToAccountNumber() + " is not available");
		} else {
			toTransactions.setUserId(toAccountDetails.get().getUserId());
			toTransactions.setAccountNumber(transferRequestDTO.getToAccountNumber());
			toTransactions.setAmount(transferRequestDTO.getToAmount());
			toTransactions.setCurrency(transferRequestDTO.getToCurrency());
			toTransactions.setDescription(transferRequestDTO.getDescription());
			toTransactions.setTransactionType("CREDIT");
			toTransactions.setStatus("Pending");
			toTransactions.setTransactionDate(LocalDateTime.now().toString());
			transactionRepository.save(toTransactions);
		}
		transactionResponseDTO.setMessage("success");
		transactionResponseDTO.setStatusCode(HttpStatus.OK.value());
		return transactionResponseDTO;
	}

	public Optional<Accounts> getAccountByID(Long accountNo) {
		Optional<Accounts> accountDetails = accountRepository.findById(accountNo);
		if(!accountDetails.isPresent()) {
			throw new InvalidAccountNumber("Account number is not available.");
		}
		return accountDetails;
	}
}
