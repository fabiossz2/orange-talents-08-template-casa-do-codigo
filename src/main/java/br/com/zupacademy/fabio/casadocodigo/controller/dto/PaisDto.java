package br.com.zupacademy.fabio.casadocodigo.controller.dto;

import br.com.zupacademy.fabio.casadocodigo.entity.Pais;

public class PaisDto {

    private String nome;

    public PaisDto(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }
}
