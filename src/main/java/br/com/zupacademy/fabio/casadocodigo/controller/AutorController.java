package br.com.zupacademy.fabio.casadocodigo.controller;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.fabio.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Autor;
import br.com.zupacademy.fabio.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(final AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converter();
        Autor autorSave = this.autorRepository.save(autor);
        return ResponseEntity.ok(new AutorDto(autorSave));
    }
}
