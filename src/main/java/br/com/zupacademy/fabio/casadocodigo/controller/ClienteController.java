package br.com.zupacademy.fabio.casadocodigo.controller;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.fabio.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.fabio.casadocodigo.entity.Cliente;
import br.com.zupacademy.fabio.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.fabio.casadocodigo.repository.EnderecoRepository;
import br.com.zupacademy.fabio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.fabio.casadocodigo.validator.EstadosPorPaisValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final EstadoRepository estadoRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteController(EstadoRepository estadoRepository, ClienteRepository clienteRepository,
                             EnderecoRepository enderecoRepository) {
        this.estadoRepository = estadoRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @InitBinder("clienteForm")
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new EstadosPorPaisValidator(estadoRepository));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm) {
        Cliente cliente = clienteForm.converterToCliente(estadoRepository, enderecoRepository);
        this.clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteDto(cliente));
    }
}
