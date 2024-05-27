package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService  userService ;
	
	
	@GetMapping
	public List<UserDto> getUsers(){
		return userService.getAllUsers();
	}
	
	
	@GetMapping("/{id}")
	public Optional<UserDto> getUserDetails(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public UserDto addUser (@RequestBody UserDto userDto) {
		return userService.CreateUser(userDto);
	}
	
	@PutMapping
	public UserDto updateUserData(@RequestBody UserDto userDto) {
		return  userService.updateUser(userDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser (@PathVariable Long id) {
		return userService.deleteUserById(id);
	}
	
}
