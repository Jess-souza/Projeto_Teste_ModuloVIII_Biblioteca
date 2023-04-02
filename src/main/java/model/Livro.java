package model;

public class Livro {
    private String titulo;
    private String autor;
    private int anoLancamento;
    private int numeroPaginas;

    public Livro(String titulo, String autor, int anoLancamento, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.numeroPaginas = numeroPaginas;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}

