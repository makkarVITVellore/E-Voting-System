package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.VoteService;

@RestController
public class VoteController {
	
	@Autowired
	VoteService voteService;
	
	@GetMapping("/get/votes")
	public List<Vote> getVotes()
	{
		return voteService.getVotes();
	}
	
	@PostMapping("/add/vote")
	public void addVote(@RequestBody Vote vote)
	{
		voteService.addVote(vote);
	}
	
	@GetMapping("/count/votes")
	public int countTotalVotes()
	{
		return voteService.countAllVotes();
	}
	
	@PostMapping("/count/election/votes")
	public long countVotesByElection(@RequestBody Election election)
	{
		return voteService.countVotesByElection(election);
	}
	
}
