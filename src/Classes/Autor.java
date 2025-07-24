package Classes;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }
}