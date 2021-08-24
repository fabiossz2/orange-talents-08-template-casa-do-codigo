package br.com.zupacademy.fabio.casadocodigo.validator;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.fabio.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Categoria;
import br.com.zupacademy.fabio.casadocodigo.repository.CategoryRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class NomeCategoriaDuplicada implements Validator {

    private CategoryRepository categoryRepository;

    public NomeCategoriaDuplicada(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoriaForm categoriaForm = (CategoriaForm) target;
        Optional<Categoria> categoriaOptional = this.categoryRepository.findByNome(categoriaForm.getNome());
        if (categoriaOptional.isPresent()) {
            errors.rejectValue("nome", null, "O nome da Categoria deve ser única.");
        }
    }
}
