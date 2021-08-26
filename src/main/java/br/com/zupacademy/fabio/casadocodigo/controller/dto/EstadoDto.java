package br.com.zupacademy.fabio.casadocodigo.controller.dto;

import br.com.zupacademy.fabio.casadocodigo.entity.Estado;

public class EstadoDto {

    private String nome;
    private String pais;

    public EstadoDto(Estado estado) {
        this.nome = estado.getNome();
        this.pais = estado.getPais().getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
}
