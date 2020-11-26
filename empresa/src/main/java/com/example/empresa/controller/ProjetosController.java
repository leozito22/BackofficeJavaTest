package com.example.empresa.controller;

import com.example.empresa.controller.dto.DepartamentoDto;
import com.example.empresa.controller.dto.ProjetoDto;
import com.example.empresa.controller.form.AtualizacaoProjetoForm;
import com.example.empresa.controller.form.ProjetoForm;
import com.example.empresa.modelo.Departamento;
import com.example.empresa.modelo.Projeto;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.ProjetoRepository;
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
@RequestMapping("projetos")
public class ProjetosController {

    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping
    public List<ProjetoDto> lista(String nomeCurso){
        List<Projeto> projetos = projetoRepository.findAll();
        return ProjetoDto.converter(projetos);

    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProjetoDto> cadastrar(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder){
        Projeto projeto = form.converter(departamentoRepository);
        projetoRepository.save(projeto);
        URI uri = uriBuilder.path("/projetos/{id}").buildAndExpand(projeto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProjetoDto(projeto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto> detalhar(@PathVariable Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(new ProjetoDto(projeto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<ProjetoDto> atualizar (@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoProjetoForm form ){
        Optional<Projeto> optional = projetoRepository.findById(id);
        if (optional.isPresent()) {
            Projeto projeto = form.atualizar(id, projetoRepository);
            return ResponseEntity.ok(new ProjetoDto(projeto));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Long id){
        Optional<Projeto> optional = projetoRepository.findById(id);
        if (optional.isPresent()) {
            projetoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
