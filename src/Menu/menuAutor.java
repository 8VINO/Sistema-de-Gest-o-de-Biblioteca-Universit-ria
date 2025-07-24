package Menu;

import java.util.Scanner;
import Controllers.ControllerAutor;

public class menuAutor {

    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuAutor() {
        int opcao = 0;

        do {
            System.out.println("\n     -- Gerenciamento de Autor --");
            System.out.println("1 - Cadastrar autor");
            System.out.println("2 - Listar autores");
            System.out.println("3 - Editar autores");
            System.out.println("4 - Remover autor");
            System.out.println("5 - Buscar autor por nome");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    ControllerAutor.cadastrarAutor();
                    break;
                case 2:
                    ControllerAutor.listarAutores();
                    break;
                case 3:
                    ControllerAutor.editarAutor();
                    break;
                case 4:
                    ControllerAutor.removerAutorPorNome();
                    break;
                case 5:
                    ControllerAutor.buscarAutorPorNome();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}
