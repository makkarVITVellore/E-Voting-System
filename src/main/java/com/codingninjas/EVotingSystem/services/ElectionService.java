package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionService {
	
	@Autowired
	ElectionRepository electionRepository;
	
	public List<Election> getAllElections() {
		
		return electionRepository.findAll();
	}
	
	
	public void saveElection(Election election) {
		
		electionRepository.save(election);
	}

}
