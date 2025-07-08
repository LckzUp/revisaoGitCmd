package com.lteste.pteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lteste.pteste.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> { //Repositorio é uma interface
    
    @Query(value = "select * from professor where nome like ?", nativeQuery = true) 
    public Professor findByNome(String nome);

}
