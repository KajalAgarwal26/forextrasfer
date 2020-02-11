package com.hcl.ing.forextransfer.service;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;

public interface TransactionService {

	TransactionResponseDTO confirmTransaction(TransactionRequestDTO transferRequestDTO);

}
