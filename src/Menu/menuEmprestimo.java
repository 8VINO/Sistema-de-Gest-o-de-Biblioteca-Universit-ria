package Menu;
import Classes.Emprestimo;
import Classes.Livro;
import Classes.Usuario;
import Classes.Aluno;
import Controllers.EmprestimoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class menuEmprestimo {

    private EmprestimoController controller;
    private List<Usuario> usuarios; // lista simulada de usuários
    private List<Livro> livros;     // lista simulada de livros

    public menuEmprestimo(List<Usuario> usuarios, List<Livro> livros) {
        this.controller = new EmprestimoController();
        this.usuarios = usuarios;
        this.livros = livros;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Menu de Empréstimo =====");
            System.out.println("1. Realizar empréstimo");
            System.out.println("2. Devolver livro");
            System.out.println("3. Listar todos os empréstimos");
            System.out.println("4. Listar empréstimos de um usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    realizarEmprestimo(scanner);
                    break;
                case 2:
                    devolverLivro(scanner);
                    break;
                case 3:
                    listarEmprestimos();
                    break;
                case 4:
                    listarEmprestimosUsuario(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void realizarEmprestimo(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = buscarUsuario(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.print("Digite o ID do livro: ");
        int livroId = scanner.nextInt();
        scanner.nextLine();

        Livro livro = buscarLivro(livroId);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        controller.realizarEmprestimo(usuario, livro);
    }

    private void devolverLivro(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = buscarUsuario(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.print("Digite o ID do livro a devolver: ");
        int livroId = scanner.nextInt();
        scanner.nextLine();

        Livro livro = buscarLivro(livroId);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        controller.devolverLivro(usuario, livro);
    }

    private void listarEmprestimos() {
        List<Emprestimo> lista = controller.listarEmprestimos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        System.out.println("Lista de empréstimos:");
        for (Emprestimo e : lista) {
            System.out.println("Usuário: " + e.getMatriculaUsuario() + " | Livro: " + e.getTomboLivro() + " | Prazo: " + e.getPrazoDevolucao());
        }
    }

    private void listarEmprestimosUsuario(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = buscarUsuario(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        controller.listarEmprestimosDoUsuario(usuario);
    }

    private Usuario buscarUsuario(int matricula) {
        for (Usuario u : usuarios) {
            if (u.getMatricula() == matricula) {
                return u;
            }
        }
        return null;
    }

    private Livro buscarLivro(int livroId) {
        for (Livro l : livros) {
            if (l.getLivroId() == livroId) {
                return l;
            }
        }
        return null;
    }
}
