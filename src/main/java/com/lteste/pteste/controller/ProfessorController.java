package com.lteste.pteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lteste.pteste.dto.ProfessorDto;
import com.lteste.pteste.modelo.Professor;
import com.lteste.pteste.repository.ProfessorRepository;

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

    @GetMapping( value = "/insert")
    public String insert(@RequestBody ProfessorDto professorDto) {

        Professor professor = professorDto.novoProfessor();
        System.out.println(professor.toString());

        

        return "<h1>Tentando Salvar o Professor dos Alunos</h1>";
    } 
}
