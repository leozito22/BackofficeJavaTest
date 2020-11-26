package com.example.empresa.controller.form;

import com.example.empresa.modelo.Endereco;
import com.example.empresa.repository.EnderecoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoEnderecoForm {

    @NotNull
    @NotEmpty
    @Length(min = 2)
    private String pais;
    @NotNull @NotEmpty @Length(min = 2)
    private String uf;
    @NotNull @NotEmpty @Length(min = 3)
    private String cidade;
    @NotNull @NotEmpty @Length(min = 5)
    private String rua;
    @NotNull @NotEmpty @Length(min = 4)
    private String cep;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Endereco atualizar(Long id, EnderecoRepository enderecoRepository) {
        Endereco endereco = enderecoRepository.getOne(id);
        endereco.setPais(this.pais);
        endereco.setUf(this.uf);
        endereco.setCidade(this.cidade);
        endereco.setRua(this.rua);
        endereco.setCep(this.cep);

        return endereco;
    }
}
