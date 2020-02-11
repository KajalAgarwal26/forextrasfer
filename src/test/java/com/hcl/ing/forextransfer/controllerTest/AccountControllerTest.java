package com.hcl.ing.forextransfer.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ing.forextransfer.controller.AccountController;
import com.hcl.ing.forextransfer.dto.AccountResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;
import com.hcl.ing.forextransfer.service.AccountService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountControllerTest {
	
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountService accountService;
	
	
	@Test
	public void testAccountDetailsPossitive() throws UserNotFoundException, AccountNotFoundException
	{
		Accounts account= new Accounts();
		account.setAccountNumber(12345L);
		account.setAccountType("Saving");
		account.setBalance(10000d);
		account.setCurrency("INR");
		account.setUserId(1L);
		
		AccountResponseDTO accountResponseDTO= new AccountResponseDTO();
		accountResponseDTO.setAccountNumber(12345L);
		accountResponseDTO.setBalance(10000d);
		accountResponseDTO.setCurrency("INR");
	Mockito.when(accountService.getAccountDetails(account.getUserId())).thenReturn(accountResponseDTO);
	HttpStatus number=	accountController.getAccountDetails(account.getUserId()).getStatusCode();
	assertEquals(HttpStatus.OK, number);
		
	}
	
	

	
	

}
