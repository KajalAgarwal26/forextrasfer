package com.hcl.ing.forextransfer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.entity.Transactions;
import com.hcl.ing.forextransfer.repository.AccountRepository;
import com.hcl.ing.forextransfer.repository.TransactionRepository;
import com.hcl.ing.forextransfer.util.ApplicationConstants;

import junit.framework.Assert;

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
	  
	  List<Transactions> transactions = new ArrayList<Transactions>();
	  Transactions debitTranasaction = null;
	  Transactions creditTranasaction = null;
	  Accounts dAccounts = null;
	  Accounts cAccounts = null;
	  Optional<Accounts> accountsDebit = null;
	  Optional<Accounts> accountsCredit = null;
	  Long refId = null;
	  
	  @Before
	  public void setUp() {		  
		 debitTranasaction = new Transactions();
		 debitTranasaction.setAccountNumber(1L); 
		 debitTranasaction.setAmount(1000.00); 
		 debitTranasaction.setCurrency("INR");
		 debitTranasaction.setRefId(10L);
		 debitTranasaction.setTransactionType(ApplicationConstants.DEBIT);
		 debitTranasaction.setStatus(ApplicationConstants.PENDING);
		 
		 creditTranasaction = new Transactions();
		 creditTranasaction.setAccountNumber(2L); 
		 creditTranasaction.setAmount(300.00); 
		 creditTranasaction.setCurrency("USD");
		 creditTranasaction.setRefId(10L);
		 creditTranasaction.setTransactionType(ApplicationConstants.CREDIT);
		 creditTranasaction.setStatus(ApplicationConstants.PENDING);
		 
		 transactions.add(debitTranasaction);
		 transactions.add(creditTranasaction);
	 
		dAccounts =new Accounts();
		dAccounts.setAccountNumber(1l);
		dAccounts.setAccountType("savings");
		dAccounts.setBalance(2000d);
		dAccounts.setCurrency("INR");
		dAccounts.setUserId(1l);
		
		cAccounts =new Accounts();
		cAccounts.setAccountNumber(1l);
		cAccounts.setAccountType("savings");
		cAccounts.setBalance(2000d);
		cAccounts.setCurrency("INR");
		cAccounts.setUserId(1l);
	 		
		accountsDebit = Optional.of(dAccounts);	
		accountsCredit = Optional.of(cAccounts);
		
	  }
	  
	/*
	 * @Test public void testConfirmTransaction() {
	 * 
	 * TransactionRequestDTO transferRequestDTO=new TransactionRequestDTO();
	 * transferRequestDTO.setFromAmount(123d);
	 * transferRequestDTO.setFromAmount(12781d);
	 * transferRequestDTO.setDescription("askfjgasjk");
	 * transferRequestDTO.setFromCurrency("INR");
	 * transferRequestDTO.setToAccountNumber(456L);
	 * transferRequestDTO.setToAmount(500d);
	 * transferRequestDTO.setToCurrency("USD"); transferRequestDTO.setCharges(122d);
	 * 
	 * 
	 * 
	 * 
	 * TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
	 * 
	 * transactionResponseDTO.setMessage("success");
	 * transactionResponseDTO.setStatus("pending");
	 * transactionResponseDTO.setStatusCode(200); Transactions transactions=new
	 * Transactions(); transactions.setAccountNumber(123l);
	 * transactions.setAmount(3400d); transactions.setCurrency("INR");
	 * transactions.setDescription("sjkfh"); transactions.setRefId(12l);
	 * transactions.setStatus("pending");
	 * transactions.setTransactionDate(LocalDateTime.now().toString());
	 * transactions.setTransactionId(1l); transactions.setTransactionType("DEBIT");
	 * transactions.setUserId(1l); Accounts accounts=new Accounts();
	 * accounts.setAccountNumber(1l); accounts.setAccountType("savings");
	 * accounts.setBalance(2000d); accounts.setCurrency("INR");
	 * accounts.setUserId(1l); Optional<Accounts> accountsre= Optional.of(accounts);
	 * 
	 * Mockito.when(transactionService.confirmTransaction(transferRequestDTO)).
	 * thenReturn(transactionResponseDTO);
	 * 
	 * Mockito.when(transactionRepository.save(transactions)).thenReturn(
	 * transactions);
	 * Mockito.when(transactionServiceImpl.getAccountByID(1l)).thenReturn(accountsre
	 * );
	 * 
	 * Mockito.when(accountRepository.findById(1l)).thenReturn(accountsre);
	 * 
	 * TransactionResponseDTO confirmTransaction =
	 * transactionServiceImpl.confirmTransaction(transferRequestDTO);
	 * assertNotEquals(confirmTransaction.getStatusCode().intValue(),200); }
	 */
	  
	  @Ignore
	  @Test
	  public void submitTransactionTest() throws AccountNotFoundException {
		  Mockito.when(transactionRepository.findByStatusAndTransactionType(ApplicationConstants.PENDING,ApplicationConstants.DEBIT)).thenReturn(transactions);
		  Mockito.when(accountRepository.findById(1L)).thenReturn(accountsDebit);
		  Mockito.when(transactionRepository.findByRefIdAndTransactionType(10L, ApplicationConstants.CREDIT)).thenReturn(creditTranasaction);
		  Mockito.when(accountRepository.findById(1L)).thenReturn(accountsCredit);
		  transactionServiceImpl.submitTransaction();		  
	  }

	  @Test

      public void testViewTransactionsById() {

             TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();

                 

                  transactionResponseDTO.setMessage("success");

                  transactionResponseDTO.setStatus("pending");

                  transactionResponseDTO.setStatusCode(200);

                  List<Transactions> listTransactions=new ArrayList<>();

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

                  listTransactions.add(transactions);

                  transactionResponseDTO.setTransactions(listTransactions);

             Mockito.when(transactionService.viewTransactionsById(1L)).thenReturn(transactionResponseDTO);

            

             TransactionResponseDTO viewTransactionsById = transactionServiceImpl.viewTransactionsById(1L);
            

             Assert.assertEquals(viewTransactionsById.getStatusCode().intValue(), 200);

      }
}
