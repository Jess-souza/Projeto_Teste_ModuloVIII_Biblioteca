package service;

import model.Livro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class BibliotecaTest {
    Biblioteca biblioteca;

    @BeforeEach
    public void beforeEach() {
        biblioteca = new Biblioteca();
    }

    @Test
    void deveTestarInclusãoDeUmLivroComTituloNulo() {
        //Given
        //When
        Livro livroComTituloNulo = new Livro(null, "Author", 2002, 56);
        IllegalArgumentException thrownComTituloNulo =
                assertThrows(IllegalArgumentException.class,
                        () -> biblioteca.addLivro(livroComTituloNulo));

        //Then
        assertEquals("O titulo do livro e nome do autor não pode ser nulo",
                thrownComTituloNulo.getMessage());

    }


    @Test
    public void deveRemoverUmLivro() {
        //Given
        Livro livro1 = new Livro("Livro 1", "Autor 1", 2001, 100);
        Livro livro2 = new Livro("Livro 2", "Autor 2", 2004, 250);
        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);

        //When
        biblioteca.removerLivro(livro1);

        //Then
        List<Livro> livros = biblioteca.getAllLivro();
        assertFalse(livros.contains(livro1));
        assertTrue(livros.contains(livro2));
    }

    @Test
    public void deveAtualizarDadosDeUmLivro() {
        //Given
        Livro atualizarLivro = new Livro("Livro 1", "autor 1", 2001, 100);
        biblioteca.addLivro(atualizarLivro);

        //When
        atualizarLivro.setTitulo("Titulo atualizado");
        atualizarLivro.setAnoLancamento(2020);
        biblioteca.atualizarLivro(atualizarLivro);

        //Then
        assertEquals("Titulo atualizado", atualizarLivro.getTitulo());
        assertEquals(2020, atualizarLivro.getAnoLancamento());
    }

    @Test
    public void deveListarLivrosExistentes() {
        //Given
        //When
        Livro livro1 = new Livro("Livro 1", "Autor 1", 2001, 100);
        Livro livro2 = new Livro("Livro 2", "Autor 2", 2004, 250);
        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);

        //Then
        List<Livro> livros = biblioteca.getAllLivro();
        assertEquals(2, livros.size());
        assertTrue(livros.containsAll(Arrays.asList(livro1, livro2)));
    }

    @Test
    public void deveRealizarBuscaDeUmLivro() {
        //Given
        Livro livro1 = new Livro("Livro 1", "Autor 1", 2001, 100);
        Livro livro2 = new Livro("Livro 2", "Autor 2", 2004, 250);
        Livro livro3 = new Livro("Livro 3", "Autor 3", 2013, 310);
        biblioteca.addLivro(livro1);
        biblioteca.addLivro(livro2);
        biblioteca.addLivro(livro3);

        //When
        List<Livro> buscaPorTitulo = biblioteca.buscarLivros("Livro 1");
        assertEquals(1, buscaPorTitulo.size());
        assertTrue(buscaPorTitulo.containsAll(Arrays.asList(livro1)));

        //Then
        List<Livro> buscaPorAutor = biblioteca.buscarLivros("Autor 2");
        assertEquals(1, buscaPorAutor.size());
        assertTrue(buscaPorAutor.contains(livro2));

    }
}
