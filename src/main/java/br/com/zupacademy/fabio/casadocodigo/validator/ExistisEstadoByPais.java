package br.com.zupacademy.fabio.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {EstadoByPaisValidator.class})
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ExistisEstadoByPais {

    String message() default "Já existe um Estado cadastrado para esse país.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
