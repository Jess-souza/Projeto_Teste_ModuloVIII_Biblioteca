package service;

import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void addLivro(Livro livro) throws IllegalArgumentException {
        if (livro.getTitulo() == null || livro.getAutor() == null) {
            throw new IllegalArgumentException("O titulo do livro e nome do autor não pode ser nulo");
        }
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public void atualizarLivro(Livro livro) {
        int index = livros.indexOf(livro);
        if (index >= 0) {
            livros.set(index, livro);
        }
    }

    public List<Livro> getAllLivro() {
        return livros;
    }

    public List<Livro> buscarLivros(String query) {
        List<Livro> result = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().contains(query) ||
                    livro.getAutor().contains(query) ||
                    Integer.toString(livro.getAnoLancamento()).contains(query)) {
                result.add(livro);
            }
        }
        return result;
    }
}
