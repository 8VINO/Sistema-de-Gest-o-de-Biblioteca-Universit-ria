package Classes;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Categoria(String nome) {
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

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
}

