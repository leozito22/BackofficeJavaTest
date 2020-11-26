package com.example.empresa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Departamento {
    @Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int numero;
    private double orcamento;
    private Date dtini;
    private Date dtfim;


    public Departamento(){};

    public Departamento(String nome, int numero, double orcamento, Date dtini, Date dtfim) {
        this.nome = nome;
        this.numero = numero;
        this.orcamento = orcamento;
        this.dtini = dtini;
        this.dtfim = dtfim;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
