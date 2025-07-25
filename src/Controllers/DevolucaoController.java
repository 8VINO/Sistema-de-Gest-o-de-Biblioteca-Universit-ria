package Controllers;

import Classes.Devolucao;
import Classes.Livro;
import Classes.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DevolucaoController {
    private List<Devolucao> devolucoes;

    public DevolucaoController() {
        this.devolucoes = new ArrayList<>();
    }

    public void registrarDevolucao(Usuario usuario, Livro livro) {
        if (!usuario.getLivros().contains(livro)) {
            System.out.println("Este livro não está emprestado para este usuário.");
            return;
        }

        usuario.devolver(livro);
        livro.setDisponibilidade(true);

        Devolucao devolucao = new Devolucao(usuario.getMatricula(), livro.getTombo(), LocalDate.now());
        devolucoes.add(devolucao);

        System.out.println("Devolução registrada com sucesso.");
    }

    public List<Devolucao> listarDevolucoes() {
        return devolucoes;
    }

    public void listarDevolucoesDoUsuario(Usuario usuario) {
        System.out.println("Devoluções do usuário: " + usuario.getNome());
        for (Devolucao d : devolucoes) {
            if (d.getMatriculaUsuario() == usuario.getMatricula()) {
                System.out.println(d);
            }
        }
    }
}
