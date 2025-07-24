package Controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Classes.Editora;

public class EditoraController {

    private static List<Editora> editorasCadastradas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static Editora buscarEditora(String nome) {
        for (Editora e : editorasCadastradas) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                return e;
            }
        }

        throw new RuntimeException("Editora " + nome + " não encontrada");
    }

    public static void cadastrarEditora() {
        System.out.print("Nome da editora: ");
        String nome = scanner.nextLine();

        if (existeEditora(nome)) {
            System.out.println("\nEditora já cadastrada.");
            return;
        }

        Editora editora = new Editora(nome);
        editorasCadastradas.add(editora);
        System.out.println("\nEditora cadastrada com sucesso!");
    }

    public static void listarEditoras() {
        if (editorasCadastradas.isEmpty()) {
            System.out.println("\nNenhuma editora cadastrada.");
            return;
        }

        System.out.println("\nEditoras cadastradas:");
        for (Editora e : editorasCadastradas) {
            System.out.println("- " + e.getNome() + " (Livros: " + e.getLivros().size() + ")");
        }
    }

    public static void removerEditoraPorNome() {
        System.out.print("Nome da editora a remover: ");
        String nome = scanner.nextLine();

        Editora encontrada = null;
        for (Editora e : editorasCadastradas) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                encontrada = e;
                break;
            }
        }

        if (encontrada != null) {
            if (!encontrada.getLivros().isEmpty()) {
                System.out.println("\nNão é possível remover a editora. Existem livros associados a ela.");
                return;
            }
            editorasCadastradas.remove(encontrada);
            System.out.println("\nEditora removida com sucesso.");
        } else {
            System.out.println("\nEditora não encontrada.");
        }
    }

    public static void buscarEditoraPorNome() {
        System.out.print("Digite o nome da editora: ");
        String nome = scanner.nextLine();

        for (Editora e : editorasCadastradas) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Editora encontrada: " + e.getNome());
                System.out.println("Quantidade de livros: " + e.getLivros().size());
                return;
            }
        }

        System.out.println("\nEditora não encontrada.");
    }

    private static boolean existeEditora(String nome) {
        return editorasCadastradas.stream()
                .anyMatch(e -> e.getNome().equalsIgnoreCase(nome));
    }


    public static void editarEditora() {
        System.out.print("Digite o nome da editora que deseja editar: ");
        String nomeAtual = scanner.nextLine();

        Editora editoraEncontrada = null;
        for (Editora e : editorasCadastradas) {
            if (e.getNome().equalsIgnoreCase(nomeAtual)) {
                editoraEncontrada = e;
                break;
            }
        }

        if (editoraEncontrada == null) {
            System.out.println("\nEditora não encontrada.");
            return;
        }

        System.out.print("Informe um novo nome para a editora (ou pressione Enter para manter): ");
        String novoNome = scanner.nextLine();

        if (novoNome.isBlank()) {
            System.out.println("\nNome mantido.");
            return;
        }

        if (existeEditora(novoNome)) {
            System.out.println("\nJá existe uma editora com esse nome.");
            return;
        }

        editoraEncontrada.setNome(novoNome);
        System.out.println("\nNome da editora atualizado com sucesso!");
    }

    public static List<Editora> getEditoras() {
        return editorasCadastradas;
    }
}
