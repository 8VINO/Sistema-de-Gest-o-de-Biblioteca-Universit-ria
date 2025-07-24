package Classes;

import java.time.LocalDate;

public class Professor extends Usuario{
    private String formacao;

    public Professor(int id, String cpf, String nome, LocalDate dataNasc, String email, int matricula, String formacao){
        super(id,cpf,nome,dataNasc,email,matricula);
        this.formacao=formacao;
    }
}
