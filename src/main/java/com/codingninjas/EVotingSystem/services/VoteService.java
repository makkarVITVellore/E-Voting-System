package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	ElectionRepository electionRepository;
	
	@Autowired
	ElectionChoiceRepository electionChoiceRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Vote> getVotes() {
		
		return voteRepository.findAll();
	}

	public void addVote(Vote vote) {
		
		/*Here also as vote has relationships with user, election and electionChoice, we will have to 
		  fetch them from the DB and then add those instances to our vote object. This will help in avoiding 
		  duplication issues and unsaved transient instance issues.*/
		
		User user = userRepository.findUserByName(vote.getUser().getName()).get();
		Election election = electionRepository.findByName(vote.getElection().getName()).get();
		ElectionChoice choice = electionChoiceRepository
				.findByNameAndElection(vote.getElectionChoice().getName(), election).get();
		vote.setElection(election);
		vote.setElectionChoice(choice);
		vote.setUser(user);
		voteRepository.save(vote);
	}

	public int countAllVotes() {
		
		return voteRepository.countAllVotes();
	}

	public long countVotesByElection(Election election) {
		
		Election existingElection = electionRepository.findByName(election.getName()).get();
		return voteRepository.countVotesByElection(existingElection);
	}

}
