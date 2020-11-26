package com.example.empresa.controller.form;

import com.example.empresa.modelo.Departamento;
import com.example.empresa.repository.DepartamentoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AtualizacaoDepartamentoForm {
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String nome;
    @NotNull
    private int numero;
    private double orcamento;
    private Date dtini;
    private Date dtfim;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public Date getDtini() {
        return dtini;
    }

    public void setDtini(Date dtini) {
        this.dtini = dtini;
    }

    public Date getDtfim() {
        return dtfim;
    }

    public void setDtfim(Date dtfim) {
        this.dtfim = dtfim;
    }

    public Departamento atualizar(Long id, DepartamentoRepository departamentoRepository) {
        Departamento departamento = departamentoRepository.getOne(id);
        departamento.setNome(this.nome);
        departamento.setNumero(this.numero);
        departamento.setOrcamento(this.orcamento);
        departamento.setDtini(this.dtini);
        departamento.setDtfim(this.dtfim);
        return departamento;
    }
}
