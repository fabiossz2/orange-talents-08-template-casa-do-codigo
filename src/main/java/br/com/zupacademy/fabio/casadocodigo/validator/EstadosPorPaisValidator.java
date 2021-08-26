package br.com.zupacademy.fabio.casadocodigo.validator;

import br.com.zupacademy.fabio.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Estado;
import br.com.zupacademy.fabio.casadocodigo.repository.EstadoRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class EstadosPorPaisValidator implements Validator {


    private final EstadoRepository estadoRepository;

    public EstadosPorPaisValidator(final EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClienteForm clienteForm = (ClienteForm) target;
        List<Estado> estados = this.estadoRepository.findByEstadosPerPais(clienteForm.getPaisId());
        if (!estados.isEmpty() && clienteForm.getEstadoId() == null) {
            errors.rejectValue("estadoId", null, "O Estado deve ser informado.");
        } else {
            Estado estado = this.estadoRepository.findByEstadoIdAndPaisId(clienteForm.getEstadoId(), clienteForm.getPaisId());
            if (estado == null) {
                errors.rejectValue("estadoId", null, "Estado inválido.");
            }
        }
    }
}
