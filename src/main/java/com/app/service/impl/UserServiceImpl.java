package com.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.mapper.UserMapper;
import com.app.repositroy.UserRepo;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo ;
	
	@Autowired
	private UserMapper mapped ;
	
	
	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = userRepo.findAll();
		
		List<UserDto> dto = users.stream().map((user)-> mapped.userMapper(user)).collect(Collectors.toList());
		
		return dto;
	}

	@Override
	public Optional<UserDto> getUserById(Long id) {
		
		Optional<User> user = userRepo.findById(id);
		
		User UserData = user.get() ;
		
		UserDto dto = mapped.userMapper(UserData);
		
		
		return Optional.of(dto);
	}

	@Override
	public UserDto CreateUser(UserDto userDto) {
		
		User user = mapped.userUnMapper(userDto);
		userRepo.save(user);
		
		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		
		UserDto dto = getUserById(userDto.getId()).orElseThrow(()-> new RuntimeException("this user Id " + userDto.getId() + " not found" ));
		
		
		User user = mapped.userUnMapper(userDto);
		user.setId(userDto.getId());
		user.setUserName(userDto.getName());
		user.setPhone(userDto.getUserPhone());
		user.setAddress(userDto.getUserAddress());
		userRepo.save(user);
		
		UserDto returnDto = mapped.userMapper(user);
		
		
		return returnDto;
	}

	@Override
	public String deleteUserById(Long id) {
		
		userRepo.deleteById(id);
		return "User id : " + id + " is deleted ";
	}

	
	
}
