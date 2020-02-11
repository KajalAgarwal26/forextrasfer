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

	/**
	 * @author Shankar This method is used to handle all runtime exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 *//*
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleAllRuntimeExceptions(RuntimeException exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.INTERNAL_SERVER_ERROR, defaultMessage);
	}

	*//**
	 * @author Shankar This method is used to handle all exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 *//*
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleAllExceptions(Exception exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.INTERNAL_SERVER_ERROR, defaultMessage);
	}

	*//**
	 * @author Shankar This method is used to handle all null pointer exception
	 *
	 * @param exection
	 * @return ApiExceptionDto with message
	 *//*
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public final ApiExceptionDto handleNullPointerExceptions(NullPointerException exection) {
		String defaultMessage = exection.getMessage();
		return new ApiExceptionDto(ApiConstant.NO_ELEMENT_FOUND, defaultMessage);
	}
*/
	


	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDto> UserNotFoundeException() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(LibraryUtil.USER_NOT_AVALIABLE);
		responseDto.setStatusCode(ApplicationConstants.NOTFOUND_CODE);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
	}
	
}