package com.hcl.ing.forextransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.ing.forextransfer.dto.ResponseDto;
import com.hcl.ing.forextransfer.util.ApplicationConstants;
import com.hcl.ing.forextransfer.util.LibraryUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InsufficientFundException.class)

	public ResponseEntity<ResponseDto> InsufficientFundException() {

		ResponseDto responseDto = new ResponseDto();

		responseDto.setMessage("Insufficient Funds");

		responseDto.setStatusCode(400);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);

	}

	@ExceptionHandler(InvalidAccountNumber.class)

	public ResponseEntity<ResponseDto> InvalidAccountNumber() {

		ResponseDto responseDto = new ResponseDto();

		responseDto.setMessage("Invalid account no");

		responseDto.setStatusCode(404);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDto> UserNotFoundeException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(LibraryUtil.USER_NOT_AVALIABLE);
		responseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}

}