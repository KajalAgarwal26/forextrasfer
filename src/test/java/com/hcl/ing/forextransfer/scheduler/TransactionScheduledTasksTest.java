package com.hcl.ing.forextransfer.scheduler;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.service.TransactionService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionScheduledTasksTest {

	@InjectMocks
	TransactionScheduledTasks scheduledTasks;
	
	@Mock
	TransactionService transactionService;
	
	@Test
	public void submitTransactionTaskTest() throws AccountNotFoundException {
		transactionService.submitTransaction();
	}	
}
