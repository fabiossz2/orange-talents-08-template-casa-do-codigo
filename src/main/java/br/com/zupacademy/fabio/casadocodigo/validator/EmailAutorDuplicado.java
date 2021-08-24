package br.com.zupacademy.fabio.casadocodigo.validator;

import br.com.zupacademy.fabio.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Autor;
import br.com.zupacademy.fabio.casadocodigo.repository.AutorRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class EmailAutorDuplicado implements Validator {

    private AutorRepository autorRepository;

    public EmailAutorDuplicado(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AutorForm autorForm = (AutorForm) target;
        Optional<Autor> emailAutor = this.autorRepository.findByEmail(autorForm.getEmail());
        if (emailAutor.isPresent()) {
            errors.rejectValue("email", null, "Email do Autor já cadastrado.");
        }
    }
}
