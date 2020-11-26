package com.example.empresa.controller.form;

import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Endereco;
import com.example.empresa.modelo.Funcionario;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EnderecoRepository;
import com.example.empresa.repository.FuncionarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

public class FuncionarioForm {
    @NotNull @NotEmpty @Length(min = 10)
    private String nome;
    @NotNull @NotEmpty @Length(min = 11)
    private String cpf;
    private Date datanascimento;
    private char sexo;
    private long idendereco;
    private long idsupervisor;
    private long iddepartamento;
    private float salario;

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

    public Funcionario converter (DepartamentoRepository departamentoRepository, FuncionarioRepository funcionarioRepository, EnderecoRepository enderecoRepository){
        Optional<Departamento> departamento = departamentoRepository.findById(iddepartamento);
        Optional<Funcionario> supervisor = funcionarioRepository.findById(idsupervisor);
        Optional<Endereco> endereco = enderecoRepository.findById(idendereco);
         return new Funcionario(nome, cpf, datanascimento, sexo, endereco.get().getId(), supervisor.get().getId(), departamento.get().getId(), salario);
    }
}
