package Controllers;

import Classes.Aluno;
import Classes.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static Usuario buscarUsuarioPorMatricula(int matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == matricula) return usuario;
        }
        return null;
    }
    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario adicionado com sucesso!");
    }
}
