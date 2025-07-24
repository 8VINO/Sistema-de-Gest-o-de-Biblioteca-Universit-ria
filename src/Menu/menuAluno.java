package Menu;

import Classes.Aluno;
import Controllers.controllerAluno;
import Controllers.ControllerUsuario;

import java.time.LocalDate;
import java.util.Scanner;

public class menuAluno {
    public static void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ALUNO ---");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno por ID");
            System.out.println("4 - Atualizar aluno");
            System.out.println("5 - Remover aluno");
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
                    String dataStr = sc.nextLine();
                    LocalDate dataNasc = LocalDate.parse(dataStr);

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Matrícula: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    Aluno a = new Aluno(cpf, nome, dataNasc, email, matricula, curso);
                    controllerAluno.adicionarAluno(a);
                    ControllerUsuario.adicionarUsuario(a);
                }
                case 2 -> controllerAluno.listarAlunos();
                case 3 -> {
                    System.out.print("ID: ");
                    int idBusca = sc.nextInt();
                    Aluno a = controllerAluno.buscarAlunoPorId(idBusca);
                    System.out.println(a != null ? a : "Aluno não encontrado.");
                }
                case 4 -> {
                    System.out.print("ID do aluno a atualizar: ");
                    int idAlt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo curso: ");
                    String novoCurso = sc.nextLine();
                    controllerAluno.atualizarAluno(idAlt, novoNome, novoCurso);
                }
                case 5 -> {
                    System.out.print("ID do aluno a remover: ");
                    int idRemover = sc.nextInt();
                    controllerAluno.removerAluno(idRemover);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
