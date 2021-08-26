package br.com.zupacademy.fabio.casadocodigo.repository;

import br.com.zupacademy.fabio.casadocodigo.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
