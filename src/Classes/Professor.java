package Classes;

import java.time.LocalDate;

public class Professor extends Usuario {
    private String formacao;

    public Professor(String cpf, String nome, LocalDate dataNasc, String email, int matricula, String formacao) {
        super(cpf, nome, dataNasc, email, matricula);
        this.formacao = formacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", formação='" + formacao + '\'' +
                '}';
    }
}
