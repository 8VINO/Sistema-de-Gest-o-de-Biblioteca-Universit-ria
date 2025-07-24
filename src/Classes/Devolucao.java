package Classes;

import java.time.LocalDate;

public class Devolucao {
    private int matriculaUsuario;
    private int tomboLivro;
    private LocalDate dataDevolucao;

    public Devolucao(int matriculaUsuario, int tomboLivro, LocalDate dataDevolucao) {
        this.matriculaUsuario = matriculaUsuario;
        this.tomboLivro = tomboLivro;
        this.dataDevolucao = dataDevolucao;
    }

    public int getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public int getTomboLivro() {
        return tomboLivro;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public String toString() {
        return "Devolução [Matrícula: " + matriculaUsuario +
                ", Tombo: " + tomboLivro +
                ", Data: " + dataDevolucao + "]";
    }
}
