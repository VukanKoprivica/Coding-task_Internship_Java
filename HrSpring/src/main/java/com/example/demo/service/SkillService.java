package com.example.demo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.SkillFoundException;
import com.example.demo.repository.SkillRepository;

import model.Skill;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository repo;
	
	public Skill addSkill(Skill skill) {
		if(repo.existsByName(skill.getName()))throw new SkillFoundException(skill.getName());
		return repo.save(skill);
	}
	public HashSet<Skill> findAll() {
		return new HashSet<Skill>(repo.findAll()) ;
	}
}
