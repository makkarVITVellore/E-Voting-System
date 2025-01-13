package com.codingninjas.EVotingSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	@Query("Select count(*) from Vote")
	public int countAllVotes();
	
	@Query("select count(*) from Vote v where v.election = ?1")
	public long countVotesByElection(Election election);

	@Query("select count(*) from Vote v where v.electionChoice=?1 and v.election=?2")
	public long getVotesForElectionChoice(ElectionChoice electionChoice, Election election);
	
	@Query("select v from Vote v where v.election=:election")
	public List<Vote> findByElection(@Param("election") Election election);
	
}
