package com.hcl.ing.forextransfer.service;

import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.AccountResponseDTO;

@Service
public interface AccountService {

	public AccountResponseDTO getAccountDetails(Long userId);
	
}
