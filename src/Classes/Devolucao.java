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
}

