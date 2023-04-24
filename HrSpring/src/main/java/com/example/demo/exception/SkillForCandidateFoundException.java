package com.example.demo.exception;

public class SkillForCandidateFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SkillForCandidateFoundException(String name,int id) {
		super("Candidate with id:"+id+" already have skill:"+name);
	}
		
}
