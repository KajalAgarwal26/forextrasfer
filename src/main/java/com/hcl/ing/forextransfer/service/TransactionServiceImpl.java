package com.hcl.ing.forextransfer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.entity.Transactions;
import com.hcl.ing.forextransfer.exception.InsufficientFundException;
import com.hcl.ing.forextransfer.exception.InvalidAccountNumber;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;
import com.hcl.ing.forextransfer.repository.AccountRepository;
import com.hcl.ing.forextransfer.repository.TransactionRepository;
import com.hcl.ing.forextransfer.util.ApplicationConstants;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public TransactionResponseDTO confirmTransaction(TransactionRequestDTO transferRequestDTO) {
		TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
		
		long refId = (long) (Math.random() * 100);
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
			fromTransactions.setTransactionType(ApplicationConstants.DEBIT);
			fromTransactions.setStatus(ApplicationConstants.PENDING);
			fromTransactions.setRefId(refId);
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
			toTransactions.setTransactionType(ApplicationConstants.CREDIT);
			toTransactions.setStatus(ApplicationConstants.PENDING);
			toTransactions.setRefId(refId);
			toTransactions.setTransactionDate(LocalDateTime.now().toString());
			transactionRepository.save(toTransactions);
		}
		transactionResponseDTO.setMessage("success");
		transactionResponseDTO.setStatusCode(HttpStatus.OK.value());
		return transactionResponseDTO;
	}

	public Optional<Accounts> getAccountByID(Long accountNo) {
		Optional<Accounts> accountDetails = accountRepository.findById(accountNo);
		if (!accountDetails.isPresent()) {
			throw new InvalidAccountNumber("Account number is not available.");
		}
		return accountDetails;
	}

	@Override
	public void submitTransaction() throws AccountNotFoundException {
		// step1: get all the pending transaction.
		List<Transactions> transactions = transactionRepository.findByStatusAndTransactionType(ApplicationConstants.PENDING,ApplicationConstants.DEBIT);
		if (!transactions.isEmpty()) {

			// step2: check whether account number is valid.
			for (Transactions debitTransaction : transactions) {
				Optional<Accounts> debitAccount = accountRepository.findById(debitTransaction.getAccountNumber());
				long refId = debitTransaction.getRefId();
				if (!debitAccount.isPresent()) {
					throw new InvalidAccountNumber("Account number is not available.");
				} 
				else if (debitAccount.get().getBalance() < debitTransaction.getAmount()) {
					throw new InsufficientFundException("Insufficient balance to complete the transafer.");
				} 
				else {
					//debit transaction info.
					debitTransaction.setStatus("Completed");
					transactionRepository.save(debitTransaction);					
					debitAccount.get().setBalance(debitAccount.get().getBalance() - debitTransaction.getAmount());
					accountRepository.save(debitAccount.get());
										
					//credit transaction info
					Transactions creditTransaction = transactionRepository.findByRefIdAndTransactionType(refId,ApplicationConstants.CREDIT);
					creditTransaction.setStatus("Completed");
					transactionRepository.save(creditTransaction);
					Optional<Accounts> creditAccount = accountRepository.findById(creditTransaction.getAccountNumber());
					if(creditAccount.isPresent()) {
						creditAccount.get().setBalance(creditAccount.get().getBalance() + creditTransaction.getAmount());
					}				
				}
			}
		}
	}
	
	@Override
    public TransactionResponseDTO viewTransactionsById(Long userId) {
           
           TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
           if(userId==null) {
                  throw new UserNotFoundException("user not found");
           }else {
           Optional<Transactions> transactionResp = transactionRepository.findById(userId);
           transactionResponseDTO.setTransactions(transactionResp);
           
           }
           return transactionResponseDTO;
    }

}
