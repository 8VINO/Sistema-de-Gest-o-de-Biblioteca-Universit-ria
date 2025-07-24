package Menu;

import Classes.Professor;
import Controllers.controllerProfessor;
import Controllers.ControllerUsuario;
import java.time.LocalDate;
import java.util.Scanner;

public class menuProfessor {
    public static void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU PROFESSOR ---");
            System.out.println("1 - Adicionar professor");
            System.out.println("2 - Listar professores");
            System.out.println("3 - Buscar professor por ID");
            System.out.println("4 - Atualizar professor");
            System.out.println("5 - Remover professor");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Data de nascimento (AAAA-MM-DD): ");
                    LocalDate dataNasc = LocalDate.parse(sc.nextLine());

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Formação: ");
                    String formacao = sc.nextLine();
                    Professor p = new Professor(cpf, nome, dataNasc, email, matricula, formacao);

                    controllerProfessor.adicionarProfessor(p);
                    ControllerUsuario.adicionarUsuario(p);
                }
                case 2 -> controllerProfessor.listarProfessores();
                case 3 -> {
                    System.out.print("ID: ");
                    int idBusca = sc.nextInt();
                    Professor p = controllerProfessor.buscarProfessorPorId(idBusca);
                    System.out.println(p != null ? p : "Professor não encontrado.");
                }
                case 4 -> {
                    System.out.print("ID do professor a atualizar: ");
                    int idAlt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo departamento: ");
                    String novoDepto = sc.nextLine();
                    controllerProfessor.atualizarProfessor(idAlt, novoNome, novoDepto);
                }
                case 5 -> {
                    System.out.print("ID do professor a remover: ");
                    int idRemover = sc.nextInt();
                    controllerProfessor.removerProfessor(idRemover);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
