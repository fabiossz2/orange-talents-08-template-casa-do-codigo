package br.com.zupacademy.fabio.casadocodigo.repository;

import br.com.zupacademy.fabio.casadocodigo.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
