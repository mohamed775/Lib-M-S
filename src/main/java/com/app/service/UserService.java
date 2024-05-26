package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.UserDto;

public interface UserService {

	
	public List<UserDto> getAllUsers();
	
	public Optional<UserDto> getUserById (Long id);
	
	public UserDto CreateUser(UserDto userDto);
	
	public UserDto updateUser(UserDto userDto);
	
	public String deleteUserById(Long id); 
	
	
}
