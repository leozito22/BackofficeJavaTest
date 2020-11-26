package com.example.empresa.repository;

import com.example.empresa.modelo.Funcionario;
import com.example.empresa.modelo.Funcionario_Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Funcionario_ProjetoRepository extends JpaRepository<Funcionario_Projeto, Long> {
    List<Funcionario_Projeto> findByidfuncionario(Long idfuncionario);
}
