package Classes;
import Interfaces.Nomeavel;

import java.time.LocalDate;
public abstract class Pessoa  implements Nomeavel {
    private static int proximoId = 1;
    protected int id ;
    protected String cpf ;
    protected String nome ;
    protected LocalDate dataNasc;

    public Pessoa( String cpf, String nome, LocalDate dataNasc) {
        this.id = proximoId++;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome=nome;
    }

}
