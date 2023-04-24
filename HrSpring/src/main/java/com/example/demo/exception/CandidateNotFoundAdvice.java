package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@ControllerAdvice
public class CandidateNotFoundAdvice {

	@RequestBody
	@ExceptionHandler({CandidateNotFoundException.class,SkillNotFoundException.class,
		SkillForCandidateNotFoundException.class,CandidateWithSkillNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> exceptionHandler(RuntimeException e){
		ResponseEntity<String> responseEntity = 
				new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	
	@RequestBody
	@ExceptionHandler({CandidateFoundException.class,SkillFoundException.class,SkillForCandidateFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> exceptionHandlerFound(RuntimeException e){
		ResponseEntity<String> responseEntity = 
				new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	
	 
}
