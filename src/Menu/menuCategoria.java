package Menu;

import java.util.Scanner;
import Controllers.CategoriaController;

public class menuCategoria {

    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuCategoria() {
        int opcao;

        do {
            System.out.println("\n   -- Gerenciamento de categorias --");
            System.out.println("1 - Cadastrar categoria");
            System.out.println("2 - Listar categorias");
            System.out.println("3 - Remover categoria");
            System.out.println("4 - Buscar categoria por nome");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    CategoriaController.cadastrarCategoria();
                    break;
                case 2:
                    CategoriaController.listarCategorias();
                    break;
                case 3:
                    CategoriaController.removerCategoriaPorNome();
                    break;
                case 4:
                    CategoriaController.buscarCategoriaPorNome();
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

