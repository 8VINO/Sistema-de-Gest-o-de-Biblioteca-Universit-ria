package Classes;

import java.time.LocalDate;

public class Aluno extends Usuario{
    private String curso;

    public Aluno( String cpf, String nome, LocalDate dataNasc, String email, int matricula,String curso){
        super(cpf,nome,dataNasc,email,matricula);
        this.curso=curso;
    }
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
