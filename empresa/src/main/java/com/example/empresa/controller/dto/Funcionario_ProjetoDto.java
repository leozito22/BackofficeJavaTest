package com.example.empresa.controller.dto;

import com.example.empresa.modelo.Funcionario_Projeto;

import java.util.List;
import java.util.stream.Collectors;

public class Funcionario_ProjetoDto {

    private long idprojeto;
    private long idfuncionario;

    public Funcionario_ProjetoDto(Funcionario_Projeto funcionario_projeto){
        this.idfuncionario = funcionario_projeto.getIdfuncionario();
        this.idprojeto = funcionario_projeto.getIdprojeto();

    }

    public static List<Funcionario_ProjetoDto> converter(List<Funcionario_Projeto> funcionario_projetos) {
        return funcionario_projetos.stream().map(Funcionario_ProjetoDto::new).collect(Collectors.toList());
    }

    public long getIdprojeto() {
        return idprojeto;
    }

    public long getIdfuncionario() {
        return idfuncionario;
    }
}
