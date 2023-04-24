package com.example.demo.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SkillService;

import model.Skill;

@RestController
@RequestMapping("/skill")
@CrossOrigin("http://localhost:3000")
public class SkillController {

	@Autowired
	SkillService service;
	
	@PostMapping("/add")
	public Skill addSkill(@RequestBody Skill skill) {
		return service.addSkill(skill);
	}
	@GetMapping("/findAll")
	public HashSet<Skill> findAllSkills() {
		return service.findAll();
	}
	
}
