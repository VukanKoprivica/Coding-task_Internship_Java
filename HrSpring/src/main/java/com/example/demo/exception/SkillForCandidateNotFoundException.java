package com.example.demo.exception;

public class SkillForCandidateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SkillForCandidateNotFoundException(String skill,int id) {
		super("No skill:"+skill+" found on candidate with id:"+id);
	}
		
}
