package br.com.zupacademy.fabio.casadocodigo.repository;

import br.com.zupacademy.fabio.casadocodigo.entity.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Estado findByNomeAndPaisId(String estado, Long paisId);
}
