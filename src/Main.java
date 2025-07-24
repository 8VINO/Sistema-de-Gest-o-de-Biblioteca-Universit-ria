import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.*;
import Classes.Usuario;
import Classes.Livro;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();


        menuEmprestimo menuEmprestimo = new menuEmprestimo(usuarios, livros);
        menuDevolucao menuDevolucao = new menuDevolucao(usuarios, livros);



        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n____ MENU PRINCIPAL ____");
            System.out.println("1 - Gerenciar livros");
            System.out.println("2 - Gerenciar editoras");
            System.out.println("3 - Gerenciar categorias");
            System.out.println("4 - Gerenciar autores");
            System.out.println("5 - Gerenciar empréstimo");
            System.out.println("6 - Gerenciar devoluções");
            System.out.println("7 - Gerenciar alunos");
            System.out.println("8 - Gerenciar professores");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    menuLivro.exibirMenuLivro();
                    break;
                case 2:
                    menuEditora.exibirMenuEditora();
                    break;
                case 3:
                    menuCategoria.exibirMenuCategoria();
                    break;
                case 4:
                    menuAutor.exibirMenuAutor();
                    break;
                case 5:
                    menuEmprestimo.iniciar();
                    break;
                case 6:
                    menuDevolucao.iniciar();
                    break;
                case 7:
                    menuAluno.exibirMenu();
                    break;
                case 8:
                    menuProfessor.exibirMenu();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }

        }
    }
}