package Controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Classes.Categoria;

public class CategoriaController {

    private static List<Categoria> categoriasCadastradas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static Categoria buscarCategoria(String nome) {
        for (Categoria c : categoriasCadastradas) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }

        throw new RuntimeException("Categoria " + nome + " não encontrada");
    }

    public static void cadastrarCategoria() {
        System.out.print("Nome da categoria: ");
        String nome = scanner.nextLine();

        if (existeCategoria(nome)) {
            System.out.println("Categoria já cadastrada.");
            return;
        }

        Categoria categoria = new Categoria(nome);
        categoriasCadastradas.add(categoria);
        System.out.println("Categoria cadastrada com sucesso!");
    }

    public static void listarCategorias() {
        if (categoriasCadastradas.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        System.out.println("\nCategorias cadastradas:");
        for (Categoria c : categoriasCadastradas) {
            System.out.println("- " + c.getNome() + " (Livros: " + c.getLivros().size() + ")");
        }
    }

    public static void removerCategoriaPorNome() {
        System.out.print("Nome da categoria a remover: ");
        String nome = scanner.nextLine();

        Categoria encontrada = null;
        for (Categoria c : categoriasCadastradas) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                encontrada = c;
                break;
            }
        }

        if (encontrada != null) {
            if (!encontrada.getLivros().isEmpty()) {
                System.out.println("Não é possível remover a categoria. Existem livros associados a ela.");
                return;
            }
            categoriasCadastradas.remove(encontrada);
            System.out.println("Categoria removida com sucesso.");
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }

    public static void buscarCategoriaPorNome() {
        System.out.print("Digite o nome da categoria: ");
        String nome = scanner.nextLine();

        for (Categoria c : categoriasCadastradas) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Categoria encontrada: " + c.getNome());
                System.out.println("Quantidade de livros: " + c.getLivros().size());
                return;
            }
        }

        System.out.println("Categoria não encontrada.");
    }

    private static boolean existeCategoria(String nome) {
        return categoriasCadastradas.stream()
                .anyMatch(c -> c.getNome().equalsIgnoreCase(nome));
    }

    public static void editarCategoria() {
        System.out.print("Digite o nome da categoria que deseja editar: ");
        String nomeAtual = scanner.nextLine();

        Categoria categoriaEncontrada = null;
        for (Categoria c : categoriasCadastradas) {
            if (c.getNome().equalsIgnoreCase(nomeAtual)) {
                categoriaEncontrada = c;
                break;
            }
        }

        if (categoriaEncontrada == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        System.out.print("Novo nome para a categoria (ou pressione Enter para manter): ");
        String novoNome = scanner.nextLine();

        if (novoNome.isBlank()) {
            System.out.println("Nome mantido.");
            return;
        }

        if (existeCategoria(novoNome)) {
            System.out.println("Já existe uma categoria com esse nome.");
            return;
        }

        categoriaEncontrada.setNome(novoNome);
        System.out.println("Categoria atualizada com sucesso!");
    }

    public static List<Categoria> getCategorias() {
        return categoriasCadastradas;
    }
}

