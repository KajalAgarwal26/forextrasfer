package com.hcl.ing.forextransfer.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.service.TransactionService;
import com.hcl.ing.forextransfer.service.TransactionServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceImplTest {

	  @InjectMocks 
	  TransactionService transactionService;
	  
	  @Mock 
	  TransactionServiceImpl transactionServiceImpl;
	  
	  @Test
	  public void testConfirmTransaction() {}
	  
}
