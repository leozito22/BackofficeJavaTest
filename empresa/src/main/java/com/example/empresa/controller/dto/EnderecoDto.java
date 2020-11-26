package com.example.empresa.controller.dto;

import com.example.empresa.modelo.Endereco;
import com.example.empresa.modelo.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDto {

    private long id;
    private String pais;
    private String uf;
    private String cidade;
    private String rua;
    private String cep;

    public EnderecoDto(Endereco endereco) {
        this.id = endereco.getId();
        this.pais = endereco.getPais();
        this.uf = endereco.getUf();
        this.cidade = endereco.getCidade();
        this.rua = endereco.getRua();
        this.cep = endereco.getCep();
    }

    public static List<EnderecoDto> converter(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }
}
