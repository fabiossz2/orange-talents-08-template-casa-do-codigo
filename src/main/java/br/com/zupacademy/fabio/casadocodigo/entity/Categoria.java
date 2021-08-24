package br.com.zupacademy.fabio.casadocodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Deprecated
    protected Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
