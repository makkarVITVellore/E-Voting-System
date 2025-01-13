package com.codingninjas.EVotingSystem.services;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class ResultsService {
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	ElectionRepository electionRepository;
	
	public ElectionChoice checkWinnerForElection(Election election) {
		
		//get the election from the database - this will move the election from detached to persistent state
		Election existingElection = electionRepository.findByName(election.getName()).get();
		
		//get all the votes for the given election
		List<Vote> votes = voteRepository.findByElection(existingElection);
		
		//create a map to store the count of votes for each choice 
		Map<ElectionChoice,Long> choiceVsVotes = new HashMap<>();
		for(Vote v:votes) {
			ElectionChoice choice = v.getElectionChoice();
			
			if(choiceVsVotes.containsKey(choice)) {
				long count = choiceVsVotes.get(choice);
				choiceVsVotes.put(choice,count+1);
			}else {
				choiceVsVotes.put(choice,1L);
			}
		}
		
		//find the election choice having the max no of votes and return that choice
		ElectionChoice winner = null;
		long max = -1;
		for(Map.Entry<ElectionChoice, Long> entry : choiceVsVotes.entrySet())
		{
			if(entry.getValue()>max)
			{
				winner = entry.getKey();
				max = entry.getValue();
			}
			
		}
		
		return winner;
	}

}
