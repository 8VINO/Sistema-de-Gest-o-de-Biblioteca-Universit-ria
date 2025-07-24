package Classes;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
public abstract class Usuario extends Pessoa {
    protected String email;
    protected int matricula;
    protected List<Livro> livros;


    public Usuario(String cpf, String nome,LocalDate dataNasc,String email, int matricula){
        super(cpf,nome,dataNasc);
        this.email=email;
        this.matricula=matricula;
        this.livros= new ArrayList<>();
    }

    public void pegarEmprestado(Livro livro){
        livros.add(livro);
    }
    public void devolver(Livro livro){
        livros.remove(livro);
    }
}
