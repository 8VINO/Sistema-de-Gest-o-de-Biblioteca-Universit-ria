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
            usuario.pegarEmprestado(livro); // adiciona o livro ao usuário
            Emprestimo e = new Emprestimo(usuario.getMatricula(), livro.getLivroId());
            emprestimos.add(e); // armazena no controle central
            livro.setDisponibilidade(false); // marca livro como emprestado
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

    public void devolverLivro(Usuario usuario, Livro livro) {
        usuario.devolver(livro);
        livro.setDisponibilidade(true); // marca como disponível novamente
        System.out.println("Livro devolvido com sucesso!");
        // (opcional) remover empréstimo do controle central
        // ou marcar como devolvido, dependendo da lógica do sistema
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