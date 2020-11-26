package com.example.empresa.controller.form;

import com.example.empresa.modelo.Funcionario;
import com.example.empresa.modelo.Funcionario_Projeto;
import com.example.empresa.repository.FuncionarioRepository;
import com.example.empresa.repository.Funcionario_ProjetoRepository;

public class AtualizacaoFuncionario_ProjetoForm {
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

    public Funcionario_Projeto atualizar(Long id, Funcionario_ProjetoRepository funcionario_projetoRepository) {

        Funcionario_Projeto funcionario_projeto = funcionario_projetoRepository.getOne(id);
        funcionario_projeto.setIdfuncionario(this.idfuncionario);
        funcionario_projeto.setIdprojeto(this.idprojeto);

        return funcionario_projeto;
    }
}
