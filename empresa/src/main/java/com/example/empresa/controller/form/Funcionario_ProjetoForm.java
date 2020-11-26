package com.example.empresa.controller.form;

import com.example.empresa.modelo.*;
import com.example.empresa.repository.FuncionarioRepository;
import com.example.empresa.repository.ProjetoRepository;

import java.util.Optional;

public class Funcionario_ProjetoForm {

    private long idprojeto;
    private long idfuncionario;

    public long getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(long idprojeto) {
        this.idprojeto = idprojeto;
    }

    public long getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(long idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario_Projeto converter (FuncionarioRepository funcionarioRepository, ProjetoRepository projetoRepository){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idfuncionario);
        Optional<Projeto> projeto = projetoRepository.findById(idprojeto);
        return new Funcionario_Projeto(funcionario.get().getId(), projeto.get().getId());
    }
}
