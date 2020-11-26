package com.example.empresa.controller.dto;

import com.example.empresa.modelo.Funcionario;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDto {

    private long id;
    private String nome;
    private String cpf;
    private Date datanascimento;
    private char sexo;
    private long idendereco;
    private long idsupervisor;
    private long iddepartamento;
    private float salario;

    public FuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.datanascimento = funcionario.getDatanascimento();
        this.sexo = funcionario.getSexo();
        this.iddepartamento = funcionario.getIddepartamento();
        this.idendereco = funcionario.getIdendereco();
        this.idsupervisor = funcionario.getIdsupervisor();
        this.salario = funcionario.getSalario();
    }

    public static List<FuncionarioDto> converter(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(FuncionarioDto::new).collect(Collectors.toList());
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
