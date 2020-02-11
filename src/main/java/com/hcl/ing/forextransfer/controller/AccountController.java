package com.hcl.ing.forextransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.forextransfer.dto.AccountResponseDTO;
import com.hcl.ing.forextransfer.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AccountController {
	
	@Autowired
	AccountService accountService;	
	
	@GetMapping("/getAccount/{userId}")
	public ResponseEntity<AccountResponseDTO> getAccountDetails(@PathVariable("userId") Long userId) {
		AccountResponseDTO accountResponseDTO=	accountService.getAccountDetails(userId);		
		return new ResponseEntity<>(accountResponseDTO,HttpStatus.OK);
	}
}
