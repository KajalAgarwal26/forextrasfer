package com.hcl.ing.forextransfer.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.dto.AccountResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.repository.AccountRepository;
import com.hcl.ing.forextransfer.service.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	
	  @Test 
	  public void testAccountServiceDetailsPossitive() {
		 
		  Accounts account = new Accounts();
		  account.setAccountNumber(898328L);
		  account.setAccountType("Saving");
		  account.setBalance(20000d);
		  account.setCurrency("INR");
		  account.setUserId(1L);
		  AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		  Mockito.when(accountRepository.findByUserId(account.getUserId())).thenReturn(account);
		  accountResponseDTO= accountServiceImpl.getAccountDetails(account.getUserId());
		  
		  Assert.assertNotNull(accountResponseDTO);
		  Assert.assertEquals(accountResponseDTO.getAccountNumber(),account.getAccountNumber()); 
		  }
	
}


