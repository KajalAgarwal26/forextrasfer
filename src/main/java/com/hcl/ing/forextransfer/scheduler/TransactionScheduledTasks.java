package com.hcl.ing.forextransfer.scheduler;


import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.ing.forextransfer.service.TransactionService;

@Component
public class TransactionScheduledTasks {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionScheduledTasks.class);
	
	@Autowired
	TransactionService transactionService;
	
	@Scheduled(fixedRate = 60000)
	public void submitTransactionTask() throws AccountNotFoundException {		
		logger.debug("Inside TransactionScheduledTasks :: submitTransactionTask");
		transactionService.submitTransaction();		
	}
}
