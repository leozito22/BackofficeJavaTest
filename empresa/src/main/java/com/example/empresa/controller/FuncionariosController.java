package com.example.empresa.controller;

import com.example.empresa.controller.dto.FuncionarioDto;
import com.example.empresa.controller.dto.ProjetoDto;
import com.example.empresa.controller.form.AtualizacaoFuncionarioForm;
import com.example.empresa.controller.form.FuncionarioForm;
import com.example.empresa.modelo.Funcionario;
import com.example.empresa.modelo.Projeto;
import com.example.empresa.repository.EnderecoRepository;
import com.example.empresa.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.empresa.repository.DepartamentoRepository;
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
@RequestMapping("funcionarios")

public class FuncionariosController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<FuncionarioDto> lista(Long iddepartamento, Long idsupervisor, String nome){
        if(iddepartamento == null && idsupervisor == null && nome == null ){
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            return FuncionarioDto.converter(funcionarios);
        }
        else{
            if(iddepartamento != null) {
                List<Funcionario> funcionarios = funcionarioRepository.findByiddepartamento(iddepartamento);
                return FuncionarioDto.converter(funcionarios);
            }
            else if(idsupervisor != null) {
                List<Funcionario> funcionarios = funcionarioRepository.findByidsupervisor(idsupervisor);
                return FuncionarioDto.converter(funcionarios);
            }
            else{
                List<Funcionario> funcionarios = funcionarioRepository.findBynome(nome);
                return FuncionarioDto.converter(funcionarios);
            }
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> cadastrar (@RequestBody @Valid   FuncionarioForm form, UriComponentsBuilder uriBuilder){
        Funcionario funcionario= form.converter(departamentoRepository, funcionarioRepository,enderecoRepository);
        funcionarioRepository.save(funcionario);
        URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> detalhar(@PathVariable Long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(new FuncionarioDto(funcionario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<FuncionarioDto> atualizar (@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoFuncionarioForm form ){
        Optional<Funcionario> optional = funcionarioRepository.findById(id);
        if (optional.isPresent()) {
            Funcionario funcionario = form.atualizar(id, funcionarioRepository);
            return ResponseEntity.ok(new FuncionarioDto(funcionario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Long id){
        Optional<Funcionario> optional = funcionarioRepository.findById(id);
        if (optional.isPresent()) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
