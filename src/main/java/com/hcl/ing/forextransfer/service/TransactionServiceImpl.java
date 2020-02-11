package com.hcl.ing.forextransfer.service;

import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;
import com.hcl.ing.forextransfer.repository.AccountRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	AccountRepository accountRepository;
	
	@Override
	public TransactionResponseDTO confirmTransaction(TransactionRequestDTO transferRequestDTO) {
		TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
		
		
		
		
		return transactionResponseDTO;
	}

	;

}
