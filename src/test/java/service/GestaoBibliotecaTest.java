package service;

import java.util.ArrayList;
import java.util.List;

import model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class GestaoBibliotecaTest {

    @Mock
    Biblioteca biblioteca;

    @InjectMocks
    private GestaoBiblioteca gestaoBiblioteca;

    @BeforeEach
    void beforeEach() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTotalBooks() {
        //Given
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro("Livro 1", "Autor 1", 2020, 100));
        livros.add(new Livro("Livro 2", "Autor 2", 2022, 76));
        when(biblioteca.getAllLivro()).thenReturn(livros);

        //When
        int result = gestaoBiblioteca.getTotaLivros();

        //Then
        Assertions.assertEquals(2, result);
    }
}

