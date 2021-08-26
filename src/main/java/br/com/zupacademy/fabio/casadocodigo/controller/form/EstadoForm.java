package br.com.zupacademy.fabio.casadocodigo.controller.form;

import br.com.zupacademy.fabio.casadocodigo.entity.Estado;
import br.com.zupacademy.fabio.casadocodigo.entity.Pais;
import br.com.zupacademy.fabio.casadocodigo.validator.ExistisEstadoByPais;
import br.com.zupacademy.fabio.casadocodigo.validator.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ExistisEstadoByPais
public class EstadoForm {

    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado converterToEstado(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.paisId);
        return new Estado(this.nome, pais);
    }

}



