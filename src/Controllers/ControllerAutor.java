package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Classes.Autor;

public class ControllerAutor {

    private static List<Autor> autoresCadastrados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static Autor buscarOuCriarAutor(String nome) {
        for (Autor autor : autoresCadastrados) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        Autor novo = new Autor(nome);
        autoresCadastrados.add(novo);
        return novo;
    }

    public static void cadastrarAutor() {
        System.out.print("Nome do autor: ");
        String nome = scanner.nextLine();

        if (existeAutor(nome)) {
            System.out.println("Autor já cadastrado.");
            return;
        }

        Autor autor = new Autor(nome);
        autoresCadastrados.add(autor);
        System.out.println("Autor cadastrado com sucesso!");
    }

    public static void listarAutores() {
        if (autoresCadastrados.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
            return;
        }

        System.out.println("\nAutores cadastrados:");
        for (Autor autor : autoresCadastrados) {
            System.out.println("- " + autor.getNome() + " (Livros: " + autor.getLivros().size() + ")");
        }
    }

    public static void removerAutorPorNome() {
        System.out.print("Nome do autor a remover: ");
        String nome = scanner.nextLine();

        Autor encontrado = null;
        for (Autor a : autoresCadastrados) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                encontrado = a;
                break;
            }
        }

        if (encontrado != null) {
            if (!encontrado.getLivros().isEmpty()) {
                System.out.println("Não é possível remover o autor. Existem livros associados a ele.");
                return;
            }
            autoresCadastrados.remove(encontrado);
            System.out.println("Autor removido com sucesso.");
        } else {
            System.out.println("Autor não encontrado.");
        }
    }

    public static void buscarAutorPorNome() {
        System.out.print("Digite o nome do autor: ");
        String nome = scanner.nextLine();

        for (Autor a : autoresCadastrados) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                System.out.println("\nAutor encontrado: " + a.getNome());
                System.out.println("Quantidade de livros: " + a.getLivros().size());
                return;
            }
        }

        System.out.println("Autor não encontrado.");
    }

    private static boolean existeAutor(String nome) {
        return autoresCadastrados.stream()
                .anyMatch(a -> a.getNome().equalsIgnoreCase(nome));
    }

    public static void editarAutor() {
        System.out.print("Digite o nome do autor que deseja editar: ");
        String nomeAtual = scanner.nextLine();

        Autor autorEncontrado = null;
        for (Autor a : autoresCadastrados) {
            if (a.getNome().equalsIgnoreCase(nomeAtual)) {
                autorEncontrado = a;
                break;
            }
        }

        if (autorEncontrado == null) {
            System.out.println("Autor não encontrado.");
            return;
        }

        System.out.print("Novo nome para o autor (ou pressione Enter para manter): ");
        String novoNome = scanner.nextLine();

        if (novoNome.isBlank()) {
            System.out.println("Nome mantido.");
            return;
        }

        if (existeAutor(novoNome)) {
            System.out.println("Já existe um autor com esse nome.");
            return;
        }

        autorEncontrado.setNome(novoNome);
        System.out.println("Nome do autor atualizado com sucesso!");
    }


    public static List<Autor> getAutores() {
        return autoresCadastrados;
    }
}
