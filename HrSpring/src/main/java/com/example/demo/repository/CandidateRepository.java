package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer>{

	Optional<Candidate> findByName(String name);

	@Query(value="select c from Candidate c "
			+ "inner join c.skills s where s.name like :name ")
	Optional<List<Candidate>> findAllBySkillName(@Param("name") String name);
	
	boolean existsByName(String name);

	 

}
