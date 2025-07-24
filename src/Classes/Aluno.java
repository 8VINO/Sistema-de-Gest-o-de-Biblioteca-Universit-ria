package Classes;

import java.time.LocalDate;

public class Aluno extends Usuario{
    private String curso;

    public Aluno(int id, String cpf, String nome, LocalDate dataNasc, String email, int matricula,String curso){
        super(id,cpf,nome,dataNasc,email,matricula);
        this.curso=curso;
    }
}
