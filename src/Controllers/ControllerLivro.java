package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Classes.Autor;
import Classes.Categoria;
import Classes.Editora;
import Classes.Livro;

public class ControllerLivro {

    private static List<Livro> livrosCadastrados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarLivro() {
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Tombo (código único do livro): ");
        int tombo = Integer.parseInt(scanner.nextLine());

        // Autores
        System.out.print("Nome(s) do autor (separados por vírgula): ");
        String[] nomesAutores = scanner.nextLine().split(",\\s*"); // aceita vírgula com ou sem espaço

        ArrayList<Autor> objAutores = new ArrayList<>();
        for (String nomeAutor : nomesAutores) {
            Autor autor = ControllerAutor.buscarOuCriarAutor(nomeAutor.trim());
            objAutores.add(autor);
        }
        System.out.println(objAutores.toArray(new Autor[0]));

        // Editora
        Editora editora = null;
        while (true){
            System.out.print("Nome da editora: ");
            String nomeEditora = scanner.nextLine();
            if (Objects.equals(nomeEditora, "sair"))  break;
            try {
                editora = EditoraController.buscarEditora(nomeEditora);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Digite 'sair' para cancelar o cadastro.");
            }
        }
        if (Objects.equals(editora, null)) return;

        // Categoria

        Categoria categoria = null;
        while (true){
            System.out.print("Nome da categoria: ");
            String nomeCategoria = scanner.nextLine();
            if (Objects.equals(nomeCategoria, "sair"))  break;
            try {
                categoria = CategoriaController.buscarCategoria(nomeCategoria);
                break;
            } catch (RuntimeException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println("Digite 'sair' para cancelar o cadastro.");
            }
        }
        if (Objects.equals(categoria, null)) return;



        // Criar livro
        Livro livro = new Livro(titulo, objAutores.toArray(new Autor[0]), editora, tombo);
        livro.setCategoria(categoria);

        livrosCadastrados.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }


    public static void removerLivroPorTombo() {
        System.out.print("\n Digite o tombo do livro a ser removido: ");
        int tombo = Integer.parseInt(scanner.nextLine());

        Livro livroEncontrado = null;

        for (Livro livro : livrosCadastrados) {
            if (livro.getTombo() == tombo) {
                livroEncontrado = livro;
                break;
            }
        }

        if (livroEncontrado != null) {
            livrosCadastrados.remove(livroEncontrado);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro com tombo " + tombo + " não encontrado.");
        }
    }

    public static void buscarLivroPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        boolean encontrado = false;
        for (Livro livro : livrosCadastrados) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("📘 Livro encontrado:");
                System.out.println("Tombo: " + livro.getTombo());
                System.out.println("Editora: " + livro.getEditora().getNome());
                System.out.println("Categoria: " + livro.getCategoria().getNome());
                System.out.print("Autores: ");
                for (Autor autor : livro.getAutores()) {
                    System.out.print(autor.getNome() + " ");
                }
                System.out.println("\nDisponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public static List<Livro> getLivros() {
        return livrosCadastrados;
    }

    public static void listarLivros() {
        if (livrosCadastrados.isEmpty()) {
            System.out.println("Nenhum livro cadastrado :(");
            return;
        }

        System.out.println("\n -- Lista de Livros:");
        for (Livro livro : livrosCadastrados) {
            System.out.println("- Título: " + livro.getTitulo());
            System.out.println("  Tombo: " + livro.getTombo());
            System.out.println("  Editora: " + livro.getEditora().getNome());
            System.out.println("  Categoria: " + livro.getCategoria().getNome());
            System.out.print("  Autores: ");
            for (Autor autor : livro.getAutores()) {
                System.out.print(autor.getNome() + " ");
            }
            System.out.println("\n  Disponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
            System.out.println("-------------------------------------------------");
        }
    }

    public static void editarLivro() {
    }
}

