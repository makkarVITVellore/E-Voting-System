package com.codingninjas.EVotingSystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.EVotingSystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.name=?1")
	Optional<User> findUserByName(String name);

}
