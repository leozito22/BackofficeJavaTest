package com.example.empresa.controller;


import com.example.empresa.controller.dto.EnderecoDto;
import com.example.empresa.controller.form.AtualizacaoEnderecoForm;
import com.example.empresa.controller.form.EnderecoForm;
import com.example.empresa.modelo.Endereco;
import com.example.empresa.repository.EnderecoRepository;
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
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<EnderecoDto> lista(){
        List<Endereco>enderecos = enderecoRepository.findAll();
        return EnderecoDto.converter(enderecos);

    }

    @PostMapping
    @Transactional
    public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder){
        Endereco endereco = new Endereco(form.getPais(), form.getUf(), form.getCidade(), form.getRua(), form.getCep());
        enderecoRepository.save(endereco);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> detalhar(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            return ResponseEntity.ok(new EnderecoDto(endereco.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<EnderecoDto> atualizar (@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoEnderecoForm form ){
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            Endereco endereco = form.atualizar(id, enderecoRepository);
            return ResponseEntity.ok(new EnderecoDto(endereco));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover (@PathVariable Long id){
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            enderecoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
