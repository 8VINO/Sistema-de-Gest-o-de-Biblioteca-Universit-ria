package Controllers;

import Classes.Emprestimo;
import Classes.Livro;
import Classes.Usuario;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoController {
    private List<Emprestimo> emprestimos;

    public EmprestimoController() {
        this.emprestimos = new ArrayList<>();
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        if (livro.isDisponivel()) {
            usuario.pegarEmprestado(livro);
            Emprestimo e = new Emprestimo(usuario.getMatricula(), livro.getTombo());
            emprestimos.add(e);
            livro.setDisponibilidade(false);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }


    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public void listarEmprestimosDoUsuario(Usuario usuario) {
        System.out.println("Empréstimos do usuário: " + usuario.getNome());
        for (Emprestimo e : emprestimos) {
            if (e.getMatriculaUsuario() == usuario.getMatricula()) {
                System.out.println("Livro: " + e.getTomboLivro() + " | Devolver até: " + e.getPrazoDevolucao());
            }
        }
    }


}