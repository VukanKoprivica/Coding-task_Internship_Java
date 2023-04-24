package com.example.demo.exception;

public class CandidateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CandidateNotFoundException(int id) {
		super("Candidate with id:"+id+" not found.");
	}
	public CandidateNotFoundException(String name) {
		super("Candidate with name:"+name+" not found.");
	}

}
