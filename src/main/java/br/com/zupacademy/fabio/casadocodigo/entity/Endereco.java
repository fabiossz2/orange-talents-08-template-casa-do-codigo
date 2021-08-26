package br.com.zupacademy.fabio.casadocodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @ManyToOne
    @NotNull
    private Estado estado;

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;

    @Deprecated
    protected Endereco() {
    }

    public Endereco(@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Estado estado,
                    @NotBlank String cep) {
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
