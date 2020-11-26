package com.example.empresa.modelo;

import javax.persistence.*;

@Entity
public class Funcionario_Projeto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idprojeto;
    private long idfuncionario;

    public Funcionario_Projeto (){}

    public Funcionario_Projeto(long idProjeto, long idFuncionarios) {
        this.idprojeto = idProjeto;
        this.idfuncionario = idFuncionarios;
    }

    public long getId() {
        return id;
    }

    public long getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(long idProjeto) {
        this.idprojeto = idProjeto;
    }

    public void setIdfuncionario(long idFuncionarios) {
        this.idfuncionario = idFuncionarios;
    }

    public long getIdfuncionario() {
        return idfuncionario;
    }
}
