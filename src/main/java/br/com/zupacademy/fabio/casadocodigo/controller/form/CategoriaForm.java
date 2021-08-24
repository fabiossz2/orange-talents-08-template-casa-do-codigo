package br.com.zupacademy.fabio.casadocodigo.controller.form;

import br.com.zupacademy.fabio.casadocodigo.entity.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
