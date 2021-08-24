package br.com.zupacademy.fabio.casadocodigo.controller.dto;

public class CategoriaDto {

    private String nome;

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
