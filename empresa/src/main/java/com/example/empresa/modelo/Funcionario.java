package com.example.empresa.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private Date datanascimento;
    private char sexo;
    private long idendereco;
    private long idsupervisor;
    private long iddepartamento;
    private float salario;

    public Funcionario(){}

    public Funcionario(String nome, String cpf, Date datanascimento, char sexo, long endereco, long supervisor, long departamento, float salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.idendereco = endereco;
        this.idsupervisor = supervisor;
        this.iddepartamento = departamento;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public long getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(long idendereco) {
        this.idendereco = idendereco;
    }

    public long getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(long idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    public long getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(long iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
