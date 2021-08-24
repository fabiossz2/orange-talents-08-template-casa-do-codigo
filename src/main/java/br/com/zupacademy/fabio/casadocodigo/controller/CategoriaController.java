package br.com.zupacademy.fabio.casadocodigo.controller;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.fabio.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Categoria;
import br.com.zupacademy.fabio.casadocodigo.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoryRepository categoryRepository;

    public CategoriaController(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.converter();
        Categoria categoriaSaved = this.categoryRepository.save(categoria);
        return ResponseEntity.ok(new CategoriaDto(categoriaSaved.getNome()));
    }
}
