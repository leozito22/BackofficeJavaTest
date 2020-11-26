package com.example.empresa.controller.dto;

import com.example.empresa.modelo.Projeto;

import java.util.List;
import java.util.stream.Collectors;

public class ProjetoDto {

    private String nome;
    private long idDepartamento;
    private double custo;


    public ProjetoDto (Projeto projeto){
        this.nome = projeto.getNome();
        this.idDepartamento = projeto.getIddepartamento();
        this.custo = projeto.getCusto();
    }

    public static List<ProjetoDto> converter(List<Projeto> projetos) {
        return projetos.stream().map(ProjetoDto::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public double getCusto() {
        return custo;
    }
}
