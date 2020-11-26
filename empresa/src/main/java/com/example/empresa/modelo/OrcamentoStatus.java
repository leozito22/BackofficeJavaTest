package com.example.empresa.modelo;

import java.util.List;

public class OrcamentoStatus {

    List<String> nomeDepartamentos;
    List<String> statusDepartamento;
    List<Double> valor;

    public List<OrcamentoStatus> orcamentoStatus (List<Funcionario> funcionarios, List<Projeto> projetos,
                                                  List<Funcionario_Projeto> funcionario_projetos, List<Departamento> departamentos){
        List<OrcamentoStatus> o;

        for (int i = 0; i < funcionario_projetos.size(); i++){
            
        }

        return o;
    }
}
