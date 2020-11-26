package com.example.empresa.controller.form;

import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Endereco;
import com.example.empresa.modelo.Funcionario;
import com.example.empresa.repository.FuncionarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AtualizacaoFuncionarioForm {



    private String nome;
    @NotNull
    private char sexo;
    @NotNull
    private float salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Funcionario atualizar(Long id, FuncionarioRepository funcionarioRepository) {

        Funcionario funcionario = funcionarioRepository.getOne(id);
        funcionario.setNome(this.nome);
        funcionario.setSexo(this.sexo);
        funcionario.setSalario(this.salario);
        return funcionario;
    }
}
