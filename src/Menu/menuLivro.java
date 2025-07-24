package Menu;

import java.util.Scanner;
import Controllers.ControllerLivro;

public class menuLivro {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuLivro() {
        int opcao;
        do {
            System.out.println("\n📚 Sistema de Biblioteca");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    ControllerLivro.cadastrarLivro();
                    break;
                case 2:
                    ControllerLivro.listarLivros();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}

