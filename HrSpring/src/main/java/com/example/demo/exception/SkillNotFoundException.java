package com.example.demo.exception;

public class SkillNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SkillNotFoundException(int id) {
		super("Skill with id:"+id+" not found.");
	}
	public SkillNotFoundException(String name) {
		super("Skill with name:"+name+" not found.");
	}

}
