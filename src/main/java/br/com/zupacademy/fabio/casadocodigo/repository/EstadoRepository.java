package br.com.zupacademy.fabio.casadocodigo.repository;

import br.com.zupacademy.fabio.casadocodigo.entity.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Estado findByNomeAndPaisId(String estado, Long paisId);

    @Query("from Estado e inner join e.pais p where p.id = :paisId")
    List<Estado> findByEstadosPerPais(@Param("paisId") Long paisId);

    @Query("from Estado e inner join e.pais p where p.id = :paisId and e.id = :estadoId")
    Estado findByEstadoIdAndPaisId(Long estadoId, Long paisId);


}
