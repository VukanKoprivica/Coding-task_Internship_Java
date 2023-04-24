package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	Optional<Skill> findByName(String name);
	boolean existsByName(String name);

}
