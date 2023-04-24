package com.example.demo.service;


import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CandidateFoundException;
import com.example.demo.exception.CandidateNotFoundException;
import com.example.demo.exception.CandidateWithSkillNotFoundException;
import com.example.demo.exception.SkillForCandidateFoundException;
import com.example.demo.exception.SkillForCandidateNotFoundException;
import com.example.demo.exception.SkillNotFoundException;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.SkillRepository;

import model.Candidate;
import model.Skill;


@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository repo;
	@Autowired
	private SkillRepository skillRepo;

	public Candidate addCandidate(Candidate candidate) {
		Skill newSkill;
		Skill old;
		if(repo.existsByName(candidate.getName())) {
			 throw new CandidateFoundException(candidate.getName());
		}
		 HashSet<Skill> newSkills= new HashSet<>();
		 if(!candidate.getSkills().isEmpty()) {
			 Iterator<Skill> iterator = candidate.getSkills().iterator();
			 while(iterator.hasNext()) {
				newSkill = iterator.next();
				
				old = skillRepo.findByName(newSkill.getName()).orElse(null);
				 if(old!=null) {
					 newSkills.add(old);
				 }else {
					 newSkills.add(newSkill);
				 }
			 }
		 }
		candidate.setSkills(newSkills);
		return repo.save(candidate);
	}
	
	public Candidate find(int id) {
		return repo.findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
	}

	public Candidate updateCandidate(int id, String name){
		if(!repo.existsById(id)) {
			throw new CandidateNotFoundException(id);
		}
			Candidate candidate = repo.findById(id).get();
			
			if(!skillRepo.existsByName(name)) {
				Skill skill = new Skill();
				skill.setName(name);
				candidate.getSkills().add(skill);
			}else {
				if(candidate.getSkills().contains(skillRepo.findByName(name).get()))
					throw new SkillForCandidateFoundException(name,id);
				candidate.getSkills().add(skillRepo.findByName(name).get());
			}
			
			return repo.save(candidate);
	}

	public HashSet<Candidate> findAll() {
		return new HashSet<Candidate>(repo.findAll());
	}
	public Candidate removeCandidate(int id) {
		if(!repo.existsById(id)) {
			throw new CandidateNotFoundException(id);
		}
		Candidate old = repo.findById(id).get();
		  for(Skill s : old.getSkills()) { 
			  s.getCandidates().remove(old); }
		repo.delete(old);
		return old;
	}
	
	public Candidate removeSkill(int id,String name) {
		Candidate candidate = repo.findById(id).orElseThrow(()->new CandidateNotFoundException(id));
		Skill skill =skillRepo.findByName(name).orElseThrow(()->new SkillNotFoundException(name));
		if(!candidate.getSkills().contains(skill)) {
			throw new SkillForCandidateNotFoundException(name,id);
		}
		candidate.getSkills().remove(skill);
		return repo.save(candidate);
	}
	
	public HashSet<Candidate> search(String name){
		if(!skillRepo.existsByName(name))throw new SkillNotFoundException(name);
		if(repo.findAllBySkillName(name).get().isEmpty()) throw new CandidateWithSkillNotFoundException(name);
		return new HashSet<>(repo.findAllBySkillName(name).get());
	}

	public Candidate searchByName(String name) {
		return repo.findByName(name).orElseThrow(()->new CandidateNotFoundException(name));
	}
}
