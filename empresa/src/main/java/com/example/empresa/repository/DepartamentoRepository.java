package com.example.empresa.repository;

import com.example.empresa.modelo.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository <Departamento, Long> {

}
