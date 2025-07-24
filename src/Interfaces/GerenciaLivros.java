package Interfaces;

import Classes.Livro;

import java.util.List;

public interface GerenciaLivros {
    void adicionarLivro(Livro livro);
    void removerLivro(Livro livro);
    List<Livro> getLivros();

}
