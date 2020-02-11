package com.hcl.ing.forextransfer.service;

import com.hcl.ing.forextransfer.dto.AccountResponseDTO;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;

public interface AccountService {

	public AccountResponseDTO getAccountDetails(Long userId) throws UserNotFoundException;
	
}
