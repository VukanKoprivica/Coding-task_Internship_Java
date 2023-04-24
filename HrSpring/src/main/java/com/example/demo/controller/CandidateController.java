package com.example.demo.controller;

import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CandidateService;

import model.Candidate;

@RestController
@RequestMapping("/candidate")
@CrossOrigin("http://localhost:3000")
public class CandidateController {

	
	@Autowired
	private CandidateService service;
	
	@PostMapping("/add")
	public Candidate addCandidate(@RequestBody Candidate candidate) {
		return service.addCandidate(candidate);
	}
	@GetMapping("/find/{id}")
	public Candidate find(@PathVariable int id) {
		return service.find(id);
	}
		
	@GetMapping("/findAll")
	public HashSet<Candidate> findAll() {
		return service.findAll();
	}
	
	@PutMapping("/update/{id}/{name}")
	public Candidate updateCandidateWithSkill(@PathVariable int id,@PathVariable String name) {
		return service.updateCandidate(id,name);
	}
	
	@DeleteMapping("/delete/{id}")
	public Candidate removeCandidate(@PathVariable int id) {
		return service.removeCandidate(id);
	}
	
	@DeleteMapping("/delete/{id}/{name}")
	public Candidate removeSkillFromCandidate(@PathVariable int id,@PathVariable String name) {
		return service.removeSkill(id,name);
	}
	
	@GetMapping("/search/{name}")
	public HashSet<Candidate> searchWithSkill(@PathVariable String name){
		return service.search(name);
	}
	
	@GetMapping("/findByName/{name}")
	public Candidate findByName(@PathVariable String name) {
		return service.searchByName(name);
	}
}
