package br.com.zupacademy.fabio.casadocodigo.controller.dto;

import br.com.zupacademy.fabio.casadocodigo.entity.Autor;

import java.time.LocalDateTime;

public class AutorDto {

    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCadastro;

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCadastro = autor.getDataCadastro();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
