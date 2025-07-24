package Classes;

public class Livro {
    private static int proximoId = 1;
    private int idLivro;
    private String titulo;
    private int tombo;
    private boolean disponibilidade;
    private Autor[] autores;
    private Editora editora;
    private Categoria categoria;

    public Livro(String titulo, Autor[] autores, Editora editora, int tombo) {
        idLivro = proximoId++;
        this.disponibilidade = true;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.tombo = tombo;

        editora.adicionarLivro(this);
        for (Autor autor : autores) {
            autor.adicionarLivro(this);
        }
    }

    public Livro(String titulo, Autor[] autores, Editora editora) {
        this.disponibilidade = true;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;

        editora.adicionarLivro(this);
        for (Autor autor : autores) {
            autor.adicionarLivro(this);
        }
    }

    public void setTombo(int tombo) {
        this.tombo = tombo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        categoria.adicionarLivro(this);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setAutores(Autor[] autores) {
        this.autores = autores;
    }
    public String getTitulo() {
        return titulo;
    }

    public int getTombo() {
        return tombo;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean d) {
        this.disponibilidade = d;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Editora getEditora() {
        return editora;
    }

    public Autor[] getAutores() {
        return autores;
    }
    public int getLivroId(){
        return idLivro;
    }
}
