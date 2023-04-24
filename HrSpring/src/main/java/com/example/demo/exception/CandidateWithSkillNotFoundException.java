package com.example.demo.exception;

public class CandidateWithSkillNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CandidateWithSkillNotFoundException(String name) {
		super("No candidate found with skill:"+name);
	}
		
}
