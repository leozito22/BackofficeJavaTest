package com.example.empresa.controller;


import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Funcionario;
import com.example.empresa.modelo.Funcionario_Projeto;
import com.example.empresa.modelo.Projeto;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.FuncionarioRepository;
import com.example.empresa.repository.Funcionario_ProjetoRepository;
import com.example.empresa.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("orcamento")
public class OrcamentoController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private Funcionario_ProjetoRepository funcionario_projetoRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

   List<Funcionario> funcionarios = funcionarioRepository.findAll();
   List<Departamento> departamentos = departamentoRepository.findAll();
   List<Projeto> projetos = projetoRepository.findAll();
   List<Funcionario_Projeto> funcionario_projetos = funcionario_projetoRepository.findAll();
   List<String> nomeDepartamentos;
   List<String> statusDepartamento;
   List<Double> valor;

   


}
