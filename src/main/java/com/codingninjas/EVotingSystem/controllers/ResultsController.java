package com.codingninjas.EVotingSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.services.ResultsService;

@RestController
public class ResultsController {
		
	@Autowired
	ResultsService resultsService;
	
	@PostMapping("/winner/election")
	public ElectionChoice checkWinnerForElection(@RequestBody Election election)
	{
		return resultsService.checkWinnerForElection(election);
	}
	
}
