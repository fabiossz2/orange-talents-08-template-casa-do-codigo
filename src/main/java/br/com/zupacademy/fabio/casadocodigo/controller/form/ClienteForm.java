package br.com.zupacademy.fabio.casadocodigo.controller.form;

import br.com.zupacademy.fabio.casadocodigo.entity.Cliente;
import br.com.zupacademy.fabio.casadocodigo.entity.Endereco;
import br.com.zupacademy.fabio.casadocodigo.entity.Estado;
import br.com.zupacademy.fabio.casadocodigo.entity.Pais;
import br.com.zupacademy.fabio.casadocodigo.repository.EnderecoRepository;
import br.com.zupacademy.fabio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.fabio.casadocodigo.validator.CpfOrCnpj;
import br.com.zupacademy.fabio.casadocodigo.validator.ExistsId;
import br.com.zupacademy.fabio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class ClienteForm {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOrCnpj
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String telefone;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "cep invalido")
    private String cep;

    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;

    public Cliente converterToCliente(EstadoRepository estadoRepository, EnderecoRepository enderecoRepository) {
        Estado estado = estadoRepository.findByEstadoIdAndPaisId(this.estadoId, this.paisId);
        Endereco end = new Endereco(this.endereco, complemento, cidade, estado, cep);
        enderecoRepository.save(end);
        return new Cliente(email, nome, sobrenome, documento, end, telefone);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}
