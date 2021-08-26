package br.com.zupacademy.fabio.casadocodigo.controller.dto;

import br.com.zupacademy.fabio.casadocodigo.entity.Cliente;

public class ClienteDto {

    private Long id;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
