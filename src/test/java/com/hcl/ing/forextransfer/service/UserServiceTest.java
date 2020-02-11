package com.hcl.ing.forextransfer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.forextransfer.dto.LoginDto;
import com.hcl.ing.forextransfer.dto.LoginResponseDto;
import com.hcl.ing.forextransfer.entity.Users;
import com.hcl.ing.forextransfer.repository.UserRepository;
import com.hcl.ing.forextransfer.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	
	  @Test 
	  public void testUsersLoginPossitive() {
	  
	  List<Users> listUsers=new ArrayList<>();
	  Users user=new Users();
	  user.setUserId(new Long(1));
	  user.setMobNum("289734");
	  user.seteMail("a@b.com");
	  user.setUserName("rajesh");
	  user.setPassword("8283jks"); 
	  listUsers.add(user);
	  
	  LoginDto loginDto=new LoginDto(); 
	  loginDto.setMobile(user.getMobNum());
	  loginDto.setPassword(user.getPassword());
	  
	  Mockito.when(userRepository.findAll()).thenReturn(listUsers);
	  
	  LoginResponseDto usersLogin = userServiceImpl.usersLogin(loginDto);
	  
	  
	  Assert.assertNotNull(usersLogin);
	  Assert.assertEquals(usersLogin.getStatusCode(),new Integer(200)); }
	  
	  
	  @Test 
	  public void testUsersLoginNegative() {
	  
	  List<Users> listUsers=new ArrayList<>();
	  Users user=new Users();
	  user.setUserId(new Long(1));
	  user.setMobNum("289734");
	  user.seteMail("a@b.com");
	  user.setUserName("rajesh");
	  user.setPassword("8283jks"); 
	  listUsers.add(user);
	  
	  LoginDto loginDto=new LoginDto(); 
	  loginDto.setMobile("123456");
	  loginDto.setPassword(user.getPassword());
	  
	  Mockito.when(userRepository.findAll()).thenReturn(listUsers);
	  
	  LoginResponseDto usersLogin = userServiceImpl.usersLogin(loginDto);
	  Assert.assertNotNull(usersLogin);
	  Assert.assertEquals(usersLogin.getStatusCode(),new Integer(400)); }
	 
	

}
