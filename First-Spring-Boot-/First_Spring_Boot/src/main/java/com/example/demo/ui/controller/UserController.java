package com.example.demo.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8081/users
public class UserController {
	@Autowired
    UserService userService ;
	@GetMapping
	public String getUser() {
		return "Get user is called";

	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		
		UserRest returnValue = new UserRest();
		 
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createUser, returnValue);
		return returnValue;
		
	}

	@PutMapping
	public String puttUser() {
		return "put user is called";

	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user is called";

	}
}
