package com.lteste.pteste.dto;

import com.lteste.pteste.modelo.Materia;
import com.lteste.pteste.modelo.Professor;

public class MateriaDto {
    
    private String nome;

    @Deprecated
    public MateriaDto() {
    }

    public MateriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "MateriaDto [nome=" + nome + "]";
    }

    //public Materia novaMateria(){
    //    return new Materia(this.nome);
    //}
    
}
