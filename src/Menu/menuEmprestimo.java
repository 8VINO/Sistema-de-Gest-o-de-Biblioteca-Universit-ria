package Menu;
import Classes.Emprestimo;
import Classes.Livro;
import Classes.Usuario;
import Classes.Aluno;
import Controllers.EmprestimoController;
import Controllers.ControllerUsuario;
import Controllers.ControllerLivro;
import java.util.ArrayList;
import Controllers.MultaController;
import Classes.Multa;
import java.util.List;
import java.util.Scanner;
public class menuEmprestimo {
    private MultaController multaController;
    private EmprestimoController controller;
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public menuEmprestimo(List<Usuario> usuarios, List<Livro> livros) {
        this.controller = new EmprestimoController();
        this.multaController = new MultaController();
        this.usuarios = usuarios;
        this.livros = livros;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Menu de Empréstimo =====");
            System.out.println("1. Realizar empréstimo");
            System.out.println("2. Listar todos os empréstimos");
            System.out.println("3. Listar empréstimos de um usuário");
            System.out.println("4. Verificar e aplicar multas de um usuário");
            System.out.println("5. Listar multas de um usuário");
            System.out.println("6. Pagar multa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    realizarEmprestimo(scanner);
                    break;
                case 2:
                    listarEmprestimos();
                    break;
                case 3:
                    listarEmprestimosUsuario(scanner);
                    break;
                case 4:
                    verificarMultasUsuario(scanner);
                    break;
                case 5:
                    listarMultasUsuario(scanner);
                    break;
                case 6:
                    pagarMultaUsuario(scanner);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);


    }

    private void realizarEmprestimo(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario=ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.print("Digite o tombo do livro: ");
        int tombo = scanner.nextInt();
        scanner.nextLine();

        Livro livro = ControllerLivro.buscarLivroPorTombo(tombo);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        controller.realizarEmprestimo(usuario, livro);
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

        Usuario usuario=ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        controller.listarEmprestimosDoUsuario(usuario);
    }
    private void verificarMultasUsuario(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        int multasCriadas = multaController.verificarEAtribuirMulta(controller.listarEmprestimos(), usuario);
        if (multasCriadas == 0) {
            System.out.println("Nenhuma multa encontrada ou aplicada para o usuário.");
        } else {
            System.out.println(multasCriadas + " multa(s) aplicada(s) ao usuário.");
        }
    }

    private void listarMultasUsuario(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        List<Multa> multas = multaController.getMultasDoUsuario(usuario);
        if (multas.isEmpty()) {
            System.out.println("O usuário não possui multas registradas.");
        } else {
            System.out.println("Multas do usuário:");
            for (Multa m : multas) {
                System.out.println("Livro Tombo: " + m.getTomboLivro() + " | Valor: R$" + m.getValor() + " | Pago: " + (m.isPago() ? "Sim" : "Não"));
            }
        }
    }
    private void pagarMultaUsuario(Scanner scanner) {
        System.out.print("Digite a matrícula do usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = ControllerUsuario.buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        List<Multa> multas = multaController.getMultasDoUsuario(usuario);
        List<Multa> pendentes = new ArrayList<>();

        for (Multa m : multas) {
            if (!m.isPago()) {
                pendentes.add(m);
            }
        }

        if (pendentes.isEmpty()) {
            System.out.println("O usuário não possui multas pendentes.");
            return;
        }

        System.out.println("Multas pendentes:");
        for (Multa m : pendentes) {
            System.out.println("ID: " + m.getIdMulta() +
                    " | Tombo: " + m.getTomboLivro() +
                    " | Valor: R$" + m.getValor());
        }

        System.out.print("Digite o ID da multa que deseja pagar: ");
        int idMulta = scanner.nextInt();
        scanner.nextLine();

        multaController.pagarMulta(idMulta);
    }






}
