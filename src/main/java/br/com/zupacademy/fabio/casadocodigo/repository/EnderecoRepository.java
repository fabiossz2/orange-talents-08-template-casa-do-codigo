package br.com.zupacademy.fabio.casadocodigo.repository;

import br.com.zupacademy.fabio.casadocodigo.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
}
