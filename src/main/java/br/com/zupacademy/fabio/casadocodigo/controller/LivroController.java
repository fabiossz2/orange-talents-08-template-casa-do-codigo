package br.com.zupacademy.fabio.casadocodigo.controller;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.fabio.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

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
}
