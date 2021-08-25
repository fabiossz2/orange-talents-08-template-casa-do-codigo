package br.com.zupacademy.fabio.casadocodigo.controller.dto;

public class ItemListaLivro {
    private Long id;
    private String titulo;

    public ItemListaLivro(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
