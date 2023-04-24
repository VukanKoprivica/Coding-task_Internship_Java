package com.example.demo.exception;

public class CandidateFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CandidateFoundException(int id) {
		super("Candidate with id:"+id+" already exists.");
	}
	public CandidateFoundException(String name) {
		super("Candidate with name:"+name+" already exists.");
	}
	
	
}
