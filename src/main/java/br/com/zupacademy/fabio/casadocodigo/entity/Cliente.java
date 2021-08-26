package br.com.zupacademy.fabio.casadocodigo.entity;

import br.com.zupacademy.fabio.casadocodigo.validator.CpfOrCnpj;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOrCnpj
    private String documento;

    @ManyToOne
    @NotNull
    private Endereco endereco;

    @NotBlank
    private String telefone;

    @Deprecated
    protected Cliente() {
    }

    public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank
    @CpfOrCnpj String documento, @NotNull Endereco endereco, @NotBlank String telefone) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }
}
