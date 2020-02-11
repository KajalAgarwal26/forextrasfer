package com.hcl.ing.forextransfer.service;

import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.AccountResponseDTO;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;

@Service
public interface AccountService {

	public AccountResponseDTO getAccountDetails(Long userId) throws UserNotFoundException;
	
}
