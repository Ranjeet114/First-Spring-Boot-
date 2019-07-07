package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserRepository;
import com.example.demo.io.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public com.example.demo.shared.dto.UserDto createUser(UserDto user) {
		// wright logic here
		
		
		if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record alredy exists");
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setEncryptedpassword("test");
		userEntity.setUserId("testUserId");
		
		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}

}
