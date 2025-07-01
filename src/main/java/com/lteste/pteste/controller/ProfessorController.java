package com.lteste.pteste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/professor")
public class ProfessorController {
    
    @GetMapping( value = "/imprimir")
    public void imprimir() {
        System.out.println("Chamou o metodo imprimir");
    }


    @GetMapping( value = "/ola")
    public String ola() {
        return "<h1>Chinelão</h1>";
    }


}
