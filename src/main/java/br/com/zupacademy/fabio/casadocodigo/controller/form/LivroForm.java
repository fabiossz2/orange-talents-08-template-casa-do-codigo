package br.com.zupacademy.fabio.casadocodigo.controller.form;

import br.com.zupacademy.fabio.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.fabio.casadocodigo.entity.Autor;
import br.com.zupacademy.fabio.casadocodigo.entity.Categoria;
import br.com.zupacademy.fabio.casadocodigo.entity.Livro;
import br.com.zupacademy.fabio.casadocodigo.validator.UniqueValue;

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

    private String sumario;

    @DecimalMin("20.00")
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long autorId;

    private String nomeCategoria;

    private String nomeAutor;

    public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                     @DecimalMin("20.00") BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas,
                     @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Long categoriaId,
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

        this.nomeCategoria = categoria.getNome();
        this.nomeAutor = autor.getNome();

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
                dataPublicacao, categoria, autor);
    }
}
