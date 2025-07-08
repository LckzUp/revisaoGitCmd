package com.lteste.pteste.controller;

import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lteste.pteste.dto.ProfessorDto;
import com.lteste.pteste.modelo.Professor;
import com.lteste.pteste.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController //Transforma nossa classe em um controller antigamente chamado de Bean
@RequestMapping( value = "/professor") //Mapeando a URL, navegador chama pelo value(valor)
public class ProfessorController {
    
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping( value = "/imprimir") //Mapeamento do metodo imprimir
    public void imprimir() { //void -> não retorna nada
        System.out.println("Chamou o metodo Lucas");
    }


    @GetMapping( value = "/ola")
    public String ola() { //String(Texto) -> Retona na tela para o Usuario //Não quer dizer HTML
        return "<h1>Luquetes</h1>"; //return -> Devolve  o retorno para quem chamou
    }

    @GetMapping( value = "/listaprofessor") //Select para o usuario
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @PostMapping(value = "/insert") //inserir dados ao Professor, nome e cpf
    public ResponseEntity<?> insert(@RequestBody ProfessorDto professorDto) {

        Professor professor = professorDto.novoProfessor();
        
        professorRepository.save(professor);
        
        System.out.println(professor.toString());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest() .path("/id") .buildAndExpand(professor.getId()) .toUri();

        return ResponseEntity.created(uri) .body(professor);
    } 

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id){
        Optional<Professor> professorBanco = professorRepository.findById(id);
        return ResponseEntity.ok(professorBanco.get());
    }

    @GetMapping(value = "/consultarNome/{nome}")
    public ResponseEntity<Professor> buscarProfessorPorNome(@PathVariable String nome){
        Professor professorBanco = professorRepository.findByNome(nome);
        return ResponseEntity.ok(professorBanco);
    }
}
