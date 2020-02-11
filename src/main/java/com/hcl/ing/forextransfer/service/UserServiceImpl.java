package com.hcl.ing.forextransfer.service;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.forextransfer.dto.LoginDto;
import com.hcl.ing.forextransfer.dto.LoginResponseDto;
import com.hcl.ing.forextransfer.entity.Users;
import com.hcl.ing.forextransfer.repository.UserRepository;
import com.hcl.ing.forextransfer.util.LibraryUtil;






@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		List<Users> users = userRepository.findAll();
		LoginResponseDto responseDto = new LoginResponseDto();

		for (Users user : users) {
			if ((userDto.getMobile().equalsIgnoreCase(user.getMobNum()))
					&& (user.getPassword().equals(userDto.getPassword()))) {
				responseDto.setMessage(LibraryUtil.LOGIN_SUCCESS);
				responseDto.setStatusCode(HttpStatus.OK.value());
				responseDto.setUserId(user.getUserId());
				return responseDto;
			}
		}
		responseDto.setMessage(LibraryUtil.INVALID_LOGIN);
		responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return responseDto;
	}

	
}
