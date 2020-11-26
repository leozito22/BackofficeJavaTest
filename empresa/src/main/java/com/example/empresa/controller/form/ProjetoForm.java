package com.example.empresa.controller.form;

import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Projeto;
import com.example.empresa.repository.DepartamentoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ProjetoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private long idDepartamento;
    private double custo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Projeto converter(DepartamentoRepository departamentoRepository) {
        Optional<Departamento> departamento = departamentoRepository.findById(idDepartamento);
        return new Projeto(nome, departamento.get().getId(), custo);
    }

}
