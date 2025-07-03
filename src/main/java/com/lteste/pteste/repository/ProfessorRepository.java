package com.lteste.pteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lteste.pteste.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> { //Repositorio é uma interface
    
}
