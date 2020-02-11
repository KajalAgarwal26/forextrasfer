package com.hcl.ing.forextransfer.serviceTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.entity.Transactions;
import com.hcl.ing.forextransfer.repository.AccountRepository;
import com.hcl.ing.forextransfer.repository.TransactionRepository;
import com.hcl.ing.forextransfer.service.TransactionService;
import com.hcl.ing.forextransfer.service.TransactionServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceImplTest {

	  @Mock 
	  TransactionService transactionService;
	  
	
	  @InjectMocks 
	  TransactionServiceImpl transactionServiceImpl;
	  
	  @Mock 
	  TransactionRepository transactionRepository;
	  
	  @Mock 
	  AccountRepository accountRepository; 
	  
	  @Test
	  public void testConfirmTransaction() {
		  
		TransactionRequestDTO transferRequestDTO=new TransactionRequestDTO();
		transferRequestDTO.setFromAmount(123d);
		transferRequestDTO.setFromAmount(12781d);
		transferRequestDTO.setDescription("askfjgasjk");
		transferRequestDTO.setFromCurrency("INR");
		transferRequestDTO.setToAccountNumber(456L);
		transferRequestDTO.setToAmount(500d);
		transferRequestDTO.setToCurrency("USD");
		transferRequestDTO.setCharges(122d);
		
		
		
		  
		TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
		
		transactionResponseDTO.setMessage("success");
		transactionResponseDTO.setStatus("pending");
		transactionResponseDTO.setStatusCode(200);
		Transactions transactions=new Transactions();
		transactions.setAccountNumber(123l);
		transactions.setAmount(3400d);
		transactions.setCurrency("INR");
		transactions.setDescription("sjkfh");
		transactions.setRefId(12l);
		transactions.setStatus("pending");
		transactions.setTransactionDate(LocalDateTime.now().toString());
		transactions.setTransactionId(1l);
		transactions.setTransactionType("DEBIT");
		transactions.setUserId(1l);
		Accounts accounts=new Accounts();
		accounts.setAccountNumber(1l);
		accounts.setAccountType("savings");
		accounts.setBalance(2000d);
		accounts.setCurrency("INR");
		accounts.setUserId(1l);
		Optional<Accounts> accountsre= Optional.of(accounts);
		
		Mockito.when(transactionService.confirmTransaction(transferRequestDTO)).thenReturn(transactionResponseDTO);
	
		Mockito.when(transactionRepository.save(transactions)).thenReturn(transactions);
		Mockito.when(transactionServiceImpl.getAccountByID(1l)).thenReturn(accountsre);
		
		Mockito.when(accountRepository.findById(1l)).thenReturn(accountsre);
		
		TransactionResponseDTO confirmTransaction = transactionServiceImpl.confirmTransaction(transferRequestDTO);
		assertNotEquals(confirmTransaction.getStatusCode().intValue(),200);
	  }
	  
	  
}
