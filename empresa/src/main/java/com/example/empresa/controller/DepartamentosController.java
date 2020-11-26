package com.example.empresa.controller;

import com.example.empresa.controller.dto.DepartamentoDto;
import com.example.empresa.controller.dto.FuncionarioDto;
import com.example.empresa.controller.form.AtualizacaoDepartamentoForm;
import com.example.empresa.controller.form.DepartamentoForm;
import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Funcionario;
import com.example.empresa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("departamentos")

public class DepartamentosController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<DepartamentoDto> lista(){

        List<Departamento> departamentos = departamentoRepository.findAll();
        return DepartamentoDto.converter(departamentos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DepartamentoDto> cadastrar(@RequestBody @Valid DepartamentoForm form, UriComponentsBuilder uriBuilder){
        Departamento departamento = new Departamento(form.getNome(), form.getNumero(), form.getOrcamento(), form.getDtini(),form.getDtfim());
        departamentoRepository.save(departamento);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DepartamentoDto(departamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDto> detalhar(@PathVariable Long id){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if (departamento.isPresent()) {
            return ResponseEntity.ok(new DepartamentoDto(departamento.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<DepartamentoDto> atualizar (@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoDepartamentoForm form ){
        Optional<Departamento> optional = departamentoRepository.findById(id);
        if (optional.isPresent()) {
            Departamento departamento = form.atualizar(id, departamentoRepository);
            return ResponseEntity.ok(new DepartamentoDto(departamento));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Long id){
        Optional<Departamento> optional = departamentoRepository.findById(id);
        if (optional.isPresent()) {
            departamentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
