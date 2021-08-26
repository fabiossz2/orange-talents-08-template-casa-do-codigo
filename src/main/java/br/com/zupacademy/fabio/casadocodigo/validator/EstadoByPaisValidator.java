package br.com.zupacademy.fabio.casadocodigo.validator;

import br.com.zupacademy.fabio.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Estado;
import br.com.zupacademy.fabio.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class EstadoByPaisValidator implements ConstraintValidator<ExistisEstadoByPais, EstadoForm> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void initialize(ExistisEstadoByPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoForm value, ConstraintValidatorContext context) {
        Estado estado = this.estadoRepository.findByNomeAndPaisId(value.getNome(), value.getPaisId());
        return !Objects.nonNull(estado);
    }
}
