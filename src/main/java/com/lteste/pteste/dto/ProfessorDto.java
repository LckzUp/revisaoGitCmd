package com.lteste.pteste.dto;

import com.lteste.pteste.modelo.Professor;

public class ProfessorDto {
    
    private String nome;
    private String cpf;
 
    
    //Construtores, 1 Depreciado e 1 Com atributos
    @Deprecated
    public ProfessorDto() {
    }

    public ProfessorDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Professor novoProfessor(){
        return new Professor(this.nome, this.cpf);

    }
}
