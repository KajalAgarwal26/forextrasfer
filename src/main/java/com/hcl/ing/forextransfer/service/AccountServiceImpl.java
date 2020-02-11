package com.hcl.ing.forextransfer.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.AccountResponseDTO;
import com.hcl.ing.forextransfer.entity.Accounts;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;
import com.hcl.ing.forextransfer.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountResponseDTO getAccountDetails(Long userId) throws UserNotFoundException {

		Accounts accounts = accountRepository.findByUserId(userId);
		AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		if (Objects.isNull(accounts)) {
			throw new UserNotFoundException("User Data Not Found");

		} else {
			accountResponseDTO.setAccountNumber(accounts.getAccountNumber());
			accountResponseDTO.setBalance(accounts.getBalance());
			accountResponseDTO.setCurrency(accounts.getCurrency());
		}

		return accountResponseDTO;
	}

}
