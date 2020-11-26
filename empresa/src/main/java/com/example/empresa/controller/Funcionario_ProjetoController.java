package com.example.empresa.controller;

import com.example.empresa.controller.dto.FuncionarioDto;
import com.example.empresa.controller.dto.Funcionario_ProjetoDto;
import com.example.empresa.controller.form.AtualizacaoFuncionarioForm;
import com.example.empresa.controller.form.AtualizacaoFuncionario_ProjetoForm;
import com.example.empresa.controller.form.FuncionarioForm;
import com.example.empresa.controller.form.Funcionario_ProjetoForm;
import com.example.empresa.modelo.Funcionario;
import com.example.empresa.modelo.Funcionario_Projeto;
import com.example.empresa.repository.*;
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
@RequestMapping("funcionario_projetos")
public class Funcionario_ProjetoController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
   private ProjetoRepository projetoRepository;
    @Autowired
    private Funcionario_ProjetoRepository funcionario_projetoRepository;

    @GetMapping
    public List<Funcionario_ProjetoDto> lista(Long idfuncionario){
        if(idfuncionario == null){
            List<Funcionario_Projeto> funcionario_projetos = funcionario_projetoRepository.findAll();
            return Funcionario_ProjetoDto.converter(funcionario_projetos);
        }
        else{
            List<Funcionario_Projeto> funcionario_projetos = funcionario_projetoRepository.findByidfuncionario(idfuncionario);
            return Funcionario_ProjetoDto.converter(funcionario_projetos);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Funcionario_ProjetoDto> cadastrar (@RequestBody @Valid  Funcionario_ProjetoForm form, UriComponentsBuilder uriBuilder){
        Funcionario_Projeto funcionario_projeto= form.converter(funcionarioRepository, projetoRepository);
        funcionario_projetoRepository.save(funcionario_projeto);
        URI uri = uriBuilder.path("/funcionario_projetos/{id}").buildAndExpand(funcionario_projeto.getId()).toUri();
        return ResponseEntity.created(uri).body(new Funcionario_ProjetoDto(funcionario_projeto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario_ProjetoDto> detalhar(@PathVariable Long id){
        Optional<Funcionario_Projeto> funcionario_projeto = funcionario_projetoRepository.findById(id);
        if (funcionario_projeto.isPresent()) {
            return ResponseEntity.ok(new Funcionario_ProjetoDto(funcionario_projeto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<Funcionario_ProjetoDto> atualizar (@PathVariable Long id,
                                                      @RequestBody @Valid AtualizacaoFuncionario_ProjetoForm form ){
        Optional<Funcionario_Projeto> optional = funcionario_projetoRepository.findById(id);
        if (optional.isPresent()) {
            Funcionario_Projeto funcionario_projeto = form.atualizar(id, funcionario_projetoRepository);
            return ResponseEntity.ok(new Funcionario_ProjetoDto(funcionario_projeto));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Long id){
        Optional<Funcionario_Projeto> optional = funcionario_projetoRepository.findById(id);
        if (optional.isPresent()) {
            funcionario_projetoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
