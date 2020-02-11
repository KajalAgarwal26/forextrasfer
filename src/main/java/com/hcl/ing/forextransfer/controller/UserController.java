package com.hcl.ing.forextransfer.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.forextransfer.dto.LoginDto;
import com.hcl.ing.forextransfer.dto.LoginResponseDto;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;
import com.hcl.ing.forextransfer.service.UserService;
import com.hcl.ing.forextransfer.util.LibraryUtil;


/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 30-01-2020
 */

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	 @Autowired 
	 UserService userService;
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
	 * @throws UserNotFoundException 
		 */
	 @PostMapping(value = "/login") 
	 public LoginResponseDto usersLogin(@RequestBody LoginDto loginDto) throws UserNotFoundException { 
		 LOGGER.info(LibraryUtil.LOGIN_METHOD);
		 return userService.usersLogin(loginDto);
	 }
	
	

}
