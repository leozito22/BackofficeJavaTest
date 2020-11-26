package com.example.empresa.controller.dto;

import com.example.empresa.modelo.Departamento;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoDto {

    private String nome;
    private int numero;
    private double orcamento;
    private Date dtini;
    private Date dtfim;

    public DepartamentoDto (Departamento departamento){
        this.nome = departamento.getNome();
        this.numero = departamento.getNumero();
        this.orcamento = departamento.getOrcamento();
        this.dtini = departamento.getDtini();
        this.dtfim = departamento.getDtfim();
    }

    public static List<DepartamentoDto> converter(List<Departamento> departamentos) {
       return departamentos.stream().map(DepartamentoDto::new).collect(Collectors.toList());
      }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public Date getDtini() {
        return dtini;
    }

    public Date getDtfim() {
        return dtfim;
    }
}
