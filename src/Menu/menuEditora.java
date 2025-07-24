package Menu;

import java.util.Scanner;
import Controllers.EditoraController;

public class menuEditora {

    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuEditora() {
        int opcao = 0;

        do {
            System.out.println("\n     -- Gerenciamento de Editoras --");
            System.out.println("1 - Cadastrar editora");
            System.out.println("2 - Listar editoras");
            System.out.println("3 - Remover editora");
            System.out.println("4 - Buscar editora por nome");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    EditoraController.cadastrarEditora();
                    break;
                case 2:
                    EditoraController.listarEditoras();
                    break;
                case 3:
                    EditoraController.removerEditoraPorNome();
                    break;
                case 4:
                    EditoraController.buscarEditoraPorNome();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}
