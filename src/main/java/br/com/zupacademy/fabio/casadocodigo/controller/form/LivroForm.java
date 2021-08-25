package br.com.zupacademy.fabio.casadocodigo.controller.form;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.fabio.casadocodigo.entity.Autor;
import br.com.zupacademy.fabio.casadocodigo.entity.Categoria;
import br.com.zupacademy.fabio.casadocodigo.entity.Livro;
import br.com.zupacademy.fabio.casadocodigo.validator.ExistsId;
import br.com.zupacademy.fabio.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @DecimalMin("20.00")
    @NotNull
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long categoriaId;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    private String nomeCategoria;

    private String nomeAutor;

    public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                     @DecimalMin("20.00") @NotNull BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas,
                     @NotBlank String isbn, @Future @NotNull LocalDate dataPublicacao, @NotNull Long categoriaId,
                     @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public LivroDto converterToDto() {
        return new LivroDto(titulo, resumo, sumario, preco, numeroPaginas, isbn,
                dataPublicacao, nomeCategoria, nomeAutor);
    }


    public Livro converterToLivro(EntityManager entityManager) {
        Autor autor = entityManager.find(Autor.class, autorId);
        Categoria categoria = entityManager.find(Categoria.class, categoriaId);

        Assert.state(autor != null, "Você esta querendo cadastrar um livro para um autor que nao existe no banco " + autorId);
        Assert.state(categoria != null, "Você esta querendo cadastrar um livro para uma categoria que nao existe no banco " + categoriaId);

        this.nomeCategoria = categoria.getNome();
        this.nomeAutor = autor.getNome();

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
                dataPublicacao, categoria, autor);
    }
}
