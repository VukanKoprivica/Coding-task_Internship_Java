package com.example.demo.exception;

public class SkillFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SkillFoundException(int id) {
		super("Skill with id:"+id+" already exists.");
	}
	public SkillFoundException(String name) {
		super("Skill with name:"+name+" already exists.");
	}
	
	
}
