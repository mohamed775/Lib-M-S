package com.app.mapper;


import org.springframework.stereotype.Component;

import com.app.dto.UserDto;
import com.app.entity.User;


@Component
public class UserMapper {

	public UserDto userMapper(User user) {

		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getUserName());
		dto.setUserAddress(user.getAddress());
		dto.setUserPhone(user.getPhone());

		return dto;

	}

	public User userUnMapper(UserDto userDto) {

		User user = new User();
		user.setUserName(userDto.getName());
		user.setAddress(userDto.getUserAddress());
		user.setPhone(userDto.getUserPhone());

		return user;

	}

}
