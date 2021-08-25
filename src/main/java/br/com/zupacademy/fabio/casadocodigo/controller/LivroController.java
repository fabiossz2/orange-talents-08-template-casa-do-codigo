package br.com.zupacademy.fabio.casadocodigo.controller;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.DetalheLivroDto;
import br.com.zupacademy.fabio.casadocodigo.controller.dto.ItemListaLivro;
import br.com.zupacademy.fabio.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.fabio.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroForm.converterToLivro(entityManager);
        entityManager.persist(livro);
        LivroDto livroDto = livroForm.converterToDto();
        return ResponseEntity.ok(livroDto);
    }

    @GetMapping
    public List<ItemListaLivro> lista() {
        final String jpql = "SELECT l FROM Livro l";
        List<Livro> livros = this.entityManager.createQuery(jpql, Livro.class).getResultList();
        return livros.stream().map(livro -> new ItemListaLivro(livro.getId(), livro.getTitulo()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotBlank Long id) {
        Livro livro = this.entityManager.find(Livro.class, id);
        if (livro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalheLivroDto(livro));
    }
}
