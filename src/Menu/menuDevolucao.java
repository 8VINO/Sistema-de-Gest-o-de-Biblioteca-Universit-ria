package Menu;

import Classes.Devolucao;
import Classes.Livro;
import Classes.Usuario;
import Controllers.ControllerLivro;
import Controllers.DevolucaoController;
import Controllers.ControllerUsuario;

import java.util.List;
import java.util.Scanner;

public class menuDevolucao {
    private DevolucaoController controller;
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public menuDevolucao(List<Usuario> usuarios, List<Livro> livros) {
        this.controller = new DevolucaoController();
        this.usuarios = usuarios;
        this.livros = livros;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Menu de Devolução =====");
            System.out.println("1. Registrar devolução");
            System.out.println("2. Listar todas as devoluções");
            System.out.println("3. Listar devoluções de um usuário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrarDevolucao(scanner);
                    break;
                case 2:
                    listarTodas();
                    break;
                case 3:
                    listarDoUsuario(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void registrarDevolucao(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario=ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.print("Digite o tombo do livro: ");
        int livroTombo = scanner.nextInt();
        scanner.nextLine();

        Livro livro = ControllerLivro.buscarLivroPorTombo(livroTombo);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        controller.registrarDevolucao(usuario, livro);
    }

    private void listarTodas() {
        List<Devolucao> lista = controller.listarDevolucoes();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma devolução registrada.");
        } else {
            for (Devolucao d : lista) {
                System.out.println("Usuário: " + d.getMatriculaUsuario()
                        + " | Livro: " + d.getTomboLivro()
                        + " | Data: " + d.getDataDevolucao());
            }
        }
    }

    private void listarDoUsuario(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario=ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        controller.listarDevolucoesDoUsuario(usuario);
    }

    private Usuario buscarUsuario(int matricula) {
        for (Usuario u : usuarios) {
            if (u.getMatricula() == matricula) return u;
        }
        return null;
    }

    private Livro buscarLivro(int tombo) {
        for (Livro l : livros) {
            if (l.getTombo() == tombo) return l;
        }
        return null;
    }
}
