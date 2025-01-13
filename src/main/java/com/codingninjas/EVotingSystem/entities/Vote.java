package com.codingninjas.EVotingSystem.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Vote {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long id;
	
	
	/*here Vote contains reference to the User. So in Vote table, there will be a column of user_id 
	 * in Vote table. This make Vote the holder of foreign key and hence the owner/parent of the relationship. This means that 
	 * if a vote is deleted then the corresponding user will also get deleted. */
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	
	/*In a many-to-one relationship, by default, the entity on the many side (here Vote) is the child and the entity on the
	 * one side (here Election) is the parent. This means that even if a vote is deleted, it won't delete the corresponding election. */
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Election election;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ElectionChoice electionChoice;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public ElectionChoice getElectionChoice() {
		return electionChoice;
	}

	public void setElectionChoice(ElectionChoice electionChoice) {
		this.electionChoice = electionChoice;
	}

	public long getId() {
		return id;
	}
	
}
