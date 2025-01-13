package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user) {
		
		userRepository.save(user);
		
	}

	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

}
