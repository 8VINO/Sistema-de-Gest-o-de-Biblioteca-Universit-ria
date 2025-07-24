package Classes;
import java.time.LocalDate;
public abstract class Pessoa {
    protected int id ;
    protected String cpf ;
    protected String nome ;
    protected LocalDate dataNasc;

    public Pessoa(int id, String cpf, String nome, LocalDate dataNasc) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
}
