package com.codingninjas.EVotingSystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;

public interface ElectionChoiceRepository extends JpaRepository<ElectionChoice, Long>{
	
	@Query("select count(*) from ElectionChoice ec where ec.election=:election")
	long countVotesForElection(@Param("election") Election election);
	
	
	Optional<ElectionChoice> findByNameAndElection(String electionChoiceName, Election election);

}
