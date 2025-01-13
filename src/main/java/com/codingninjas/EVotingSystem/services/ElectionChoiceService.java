package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionChoiceService {
	
	@Autowired
	ElectionChoiceRepository electionChoiceRepository;
	
	@Autowired
	ElectionRepository electionRepository;
	
	public void addElectionChoice(ElectionChoice electionChoice) {
			
			/*we cannot directly save this electionchoice as it will create a new Election.
			 * So we will first fetch the election that this choice has from the DB and then associate
			 * that to this instance so that we don't get duplication issues*/ 
		
			Election election = electionRepository.findByName(electionChoice.getElection().getName()).get();
			electionChoice.setElection(election);
			electionChoiceRepository.save(electionChoice);
	}

	public List<ElectionChoice> getElectionChoices() {
		
		return electionChoiceRepository.findAll();
	}

	public long choicesForElection(Election election) {
		
		Election existingElection = electionRepository.findByName(election.getName()).get();	
		return electionChoiceRepository.countVotesForElection(existingElection);
	}

}
