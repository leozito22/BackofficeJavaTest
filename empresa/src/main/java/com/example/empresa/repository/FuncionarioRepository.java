package com.example.empresa.repository;

import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    List<Funcionario> findByiddepartamento(Long iddepartamento);
    List<Funcionario> findByidsupervisor(Long idsupervisor);
    List<Funcionario> findBynome(String nome);

}