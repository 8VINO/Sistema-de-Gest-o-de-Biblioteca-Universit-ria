import java.util.ArrayList;
import java.util.List;

import Classes.Usuario;
import Classes.Livro;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Menu.menuAluno;
import Menu.menuProfessor;
import Menu.menuEmprestimo;


public class Main {
    public static void main(String[] args) {
        menuProfessor.exibirMenu();
        menuAluno.exibirMenu();
        List<Usuario> usuarios = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();

        // Aqui você pode adicionar usuários e livros para testes

        menuEmprestimo menu = new menuEmprestimo(usuarios, livros);
        menu.iniciar();
    }
}