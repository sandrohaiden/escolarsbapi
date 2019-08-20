package com.sandrohc2010.escolarsbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandrohc2010.escolarsbapi.model.Disciplina;
import com.sandrohc2010.escolarsbapi.model.Professor;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
}
