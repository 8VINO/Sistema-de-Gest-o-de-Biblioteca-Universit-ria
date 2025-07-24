package Classes;



import java.time.LocalDate;

public class Emprestimo {
    private int matriculaUsuario;
    private int tomboLivro;
    private LocalDate prazoDevolucao;

    public Emprestimo(int matriculaUsuario, int tomboLivro) {
        this.matriculaUsuario = matriculaUsuario;
        this.tomboLivro = tomboLivro;
        this.prazoDevolucao =  LocalDate.now().plusDays(30);
    }

    public int getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public int getTomboLivro() {
        return tomboLivro;
    }

    public LocalDate getPrazoDevolucao() {
        return prazoDevolucao;
    }
}
