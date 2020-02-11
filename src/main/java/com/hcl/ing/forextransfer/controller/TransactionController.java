package com.hcl.ing.forextransfer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;
import com.hcl.ing.forextransfer.service.TransactionService;
import com.hcl.ing.forextransfer.util.ForexUtil;


@RestController
@RequestMapping("/transaction")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired 
	 TransactionService transferService;
	 /**
		 * 
		 * @param transferRequestDTO
		 * @return transferRequestDTO 
		 */
	 @PostMapping(value = "/confirmTransaction") 
	 public ResponseEntity<TransactionResponseDTO> confirmTransaction(@RequestBody TransactionRequestDTO transferRequestDTO) { 
		 LOGGER.info(ForexUtil.LOGIN_METHOD);
		 TransactionResponseDTO transferResponseDTO = transferService.confirmTransaction(transferRequestDTO);
		 return new ResponseEntity<>(transferResponseDTO, HttpStatus.OK);
	 }
}
