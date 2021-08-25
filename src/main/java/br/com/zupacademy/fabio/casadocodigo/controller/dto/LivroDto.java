package br.com.zupacademy.fabio.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private String nomeCategoria;
    private String nomeAutor;

    public LivroDto(String titulo, String resumo, String sumario, BigDecimal preco,
                    Integer numeroPaginas, String isbn, LocalDate dataPublicacao, String nomeCategoria,
                    String nomeAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.nomeCategoria = nomeCategoria;
        this.nomeAutor = nomeAutor;
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

    public String getDataPublicacao() {
        return dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
