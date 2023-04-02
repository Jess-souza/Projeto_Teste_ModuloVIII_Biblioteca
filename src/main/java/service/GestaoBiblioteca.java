package service;

public class GestaoBiblioteca {
    private Biblioteca biblioteca;

    public GestaoBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getTotaLivros() {
        return biblioteca.getAllLivro().size();
    }

}
