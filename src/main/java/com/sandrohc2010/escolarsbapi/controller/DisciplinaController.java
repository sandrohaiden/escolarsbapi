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
import com.sandrohc2010.escolarsbapi.model.Disciplina;
import com.sandrohc2010.escolarsbapi.repository.DisciplinaRepository;

@RestController
@RequestMapping("/api")
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	
	@GetMapping("/disciplinas")
	public List<Disciplina> getAllDisciplinas() {
		return disciplinaRepository.findAll();
	}
	
	@PostMapping("/disciplinas")
	public Disciplina insertDisciplina(@Valid @RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@GetMapping("/disciplinas/{id}")
	public Disciplina getDisciplina(@PathVariable(value = "id") Long id) {
		return disciplinaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Disciplina", "id", id));
	}
	
	@PutMapping("/discipinas/{id}")
	public Disciplina updateDisciplina(@PathVariable(value = "id") Long id, @Valid @RequestBody Disciplina newDisciplina) {
		Disciplina disciplina = disciplinaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Disciplina", "id", id));
		
		return disciplinaRepository.save(newDisciplina);
	}
	
	@DeleteMapping("/disciplinas/{id}")
	public ResponseEntity<?> deleteProfessor(@PathVariable(value = "id") Long id) {
		Disciplina disciplina = disciplinaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Disciplina", "id", id));
		disciplinaRepository.delete(disciplina);
		
		return ResponseEntity.ok().build();
	}
}
