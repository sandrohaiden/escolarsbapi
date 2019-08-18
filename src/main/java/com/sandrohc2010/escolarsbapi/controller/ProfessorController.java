package com.sandrohc2010.escolarsbapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandrohc2010.escolarsbapi.exception.ResourceNotFoundException;
import com.sandrohc2010.escolarsbapi.model.Professor;
import com.sandrohc2010.escolarsbapi.repository.ProfessorRepository;

@RestController
@RequestMapping("/api")
public class ProfessorController {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	
	@GetMapping("/professores")
	public List<Professor> getAllProfessores() {
		return professorRepository.findAll();
	}
	
	@PostMapping("/professores")
	public Professor adicionarProfessor(@Valid @RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@GetMapping("/professores/{id}")
	public Professor getProfessor(@PathVariable(value = "id") Long id) {
		return professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor", "id", id));
	}
	
	@PutMapping("/professores/{id}")
	public Professor updateProfessor(@PathVariable(value = "id") Long id, @Valid @RequestBody Professor newProfessor) {
		Professor professor = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor", "id", id));
		
		return professorRepository.save(newProfessor);
	}
	
	@DeleteMapping("/professores/{id}")
	public ResponseEntity<?> deleteProfessor(@PathVariable(value = "id") Long id) {
		Professor professor = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Professor", "id", id));
		professorRepository.delete(professor);
		
		return ResponseEntity.ok().build();
	}
}
