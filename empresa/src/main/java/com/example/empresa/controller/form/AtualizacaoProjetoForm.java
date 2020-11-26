package com.example.empresa.controller.form;

import com.example.empresa.modelo.Projeto;
import com.example.empresa.repository.ProjetoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoProjetoForm {
    @NotNull
    @NotEmpty
    private String nome;
    private double custo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Projeto atualizar(Long id, ProjetoRepository projetoRepository){
        Projeto projeto = projetoRepository.getOne(id);
        projeto.setNome(this.nome);
        projeto.setCusto(this.custo);
        return projeto;
    }


}
