package com.codingninjas.EVotingSystem.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.repositories.UserRepository;

@Service
@RequiredArgsConstructor //this will provide the constructor only for fields which are final or marked with @NonNull
public class UserService {

	private final UserRepository userRepository;
	
	public User createUser(User user) {

		return userRepository.save(user);
	}

	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

}
