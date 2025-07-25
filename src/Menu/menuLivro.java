package Menu;

import java.util.Scanner;
import Controllers.ControllerLivro;

public class menuLivro {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuLivro() {
        int opcao = 0;
        do {
            System.out.println("\n     -- Gerenciamento de Livros --");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Editar Livro");
            System.out.println("4 - Deletar Livro");
            System.out.println("5 - Exibir detalhes do livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");


            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    ControllerLivro.cadastrarLivro();
                    break;
                case 2:
                    ControllerLivro.listarLivros();
                    break;
                case 3:
                    ControllerLivro.editarLivro();
                    break;
                case 4:
                    ControllerLivro.removerLivroPorTombo();
                    break;
                case 5:
                    ControllerLivro.buscarLivroPorTitulo();
                    break;
                case 6:
                    System.out.print("Digite o nome da categoria: ");
                    String nomeCategoria = scanner.nextLine();
                    ControllerLivro.listarLivros(nomeCategoria);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }
        } while (opcao != 0);
    }
}

