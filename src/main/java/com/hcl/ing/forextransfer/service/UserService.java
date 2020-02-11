package com.hcl.ing.forextransfer.service;

import com.hcl.ing.forextransfer.dto.LoginDto;
import com.hcl.ing.forextransfer.dto.LoginResponseDto;
import com.hcl.ing.forextransfer.exception.UserNotFoundException;

public interface UserService {
	
	 LoginResponseDto usersLogin(LoginDto userDto) throws UserNotFoundException; 
	 
	

}
