package com.hcl.ing.forextransfer.controllerTest;

import java.util.ArrayList;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.controller.UserController;
import com.hcl.ing.forextransfer.dto.LoginDto;
import com.hcl.ing.forextransfer.dto.LoginResponseDto;
import com.hcl.ing.forextransfer.entity.Users;
import com.hcl.ing.forextransfer.service.UserService;




@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	
	  @InjectMocks 
	  UserController userController;
	  
	  @Mock 
	  UserService userService;
	  
	  @Test 
	  public void testusersLoginPossitive() {
	  
	  List<Users> listUsers=new ArrayList<>();
	  Users user=new Users();
	  user.setUserId(new
	  Long(1));user.setMobNum("289734");user.seteMail("a@b.com");
	  user.setUserName("rajesh");
	  user.setPassword("8283jks");
	  listUsers.add(user);
	  
	  LoginDto loginDto=new LoginDto(); 
	  loginDto.setMobile(user.getMobNum());
	  loginDto.setPassword(user.getPassword());
	  
	  LoginResponseDto loginResponseDto=new LoginResponseDto();
	  loginResponseDto.setMessage("Login Success");
	  loginResponseDto.setStatusCode(200); loginResponseDto.setUserId(new Long(1));
	  
	  Mockito.when(userService.usersLogin(loginDto)).thenReturn(loginResponseDto);
	  
	  LoginResponseDto usersLogin = userController.usersLogin(loginDto);
	
	  Assert.assertNotNull(usersLogin);
	  Assert.assertEquals(usersLogin.getStatusCode(),new Integer(200)); }	
	  
	  
	  
	  @Test 
	  public void testusersLoginNegative() {
	  
	  List<Users> listUsers=new ArrayList<>();
	  Users user=new Users();
	  user.setUserId(new Long(1));
	  user.setMobNum("289734");
	  user.seteMail("a@b.com");
	  user.setUserName("rajesh");
	  user.setPassword("8283jks"); 
	  listUsers.add(user);
	  
	  LoginDto loginDto=new LoginDto(); 
	  loginDto.setMobile("99234155");
	  loginDto.setPassword(user.getPassword());
	  
	  LoginResponseDto loginResponseDto=new LoginResponseDto();
	  loginResponseDto.setMessage("Login Failed");
	  loginResponseDto.setStatusCode(400); 
	  loginResponseDto.setUserId(new Long(1));
	  
	  Mockito.when(userService.usersLogin(loginDto)).thenReturn(loginResponseDto);
	  
	  LoginResponseDto usersLogin = userController.usersLogin(loginDto);
	
	  Assert.assertNotNull(usersLogin);
	  Assert.assertEquals(usersLogin.getStatusCode(),new Integer(400)); }	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
