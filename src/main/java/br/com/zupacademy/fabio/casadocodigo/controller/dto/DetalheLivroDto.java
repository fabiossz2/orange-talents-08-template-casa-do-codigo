package br.com.zupacademy.fabio.casadocodigo.controller.dto;

import br.com.zupacademy.fabio.casadocodigo.entity.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalheLivroDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private String nomeCategoria;
    private String nomeAutor;

    public DetalheLivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.nomeCategoria = livro.getCategoria().getNome();
        this.nomeAutor = livro.getAutor().getNome();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
