package com.example.empresa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projeto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long iddepartamento;
    private double custo;

    public Projeto(){};

    public Projeto(String nome, long iddepartamento, double custo) {
        this.nome = nome;
        this.iddepartamento = iddepartamento;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(long idDepartamento) {
        this.iddepartamento = idDepartamento;
    }

    public long getId() {
        return id;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
