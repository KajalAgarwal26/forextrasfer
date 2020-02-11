package com.hcl.ing.forextransfer.service;

import com.hcl.ing.forextransfer.dto.LoginDto;
import com.hcl.ing.forextransfer.dto.LoginResponseDto;

public interface UserService {
	
	 LoginResponseDto usersLogin(LoginDto userDto); 
}
