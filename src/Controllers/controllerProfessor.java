package Controllers;

import Classes.Professor;
import java.util.ArrayList;
import java.util.List;

public class controllerProfessor {
    private static List<Professor> professores = new ArrayList<>();

    // CREATE
    public static void adicionarProfessor(Professor professor) {
        professores.add(professor);
        System.out.println("Professor adicionado com sucesso!");
    }

    // READ
    public static Professor buscarProfessorPorId(int id) {
        for (Professor prof : professores) {
            if (prof.getId() == id) return prof;
        }
        return null;
    }

    public static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor p : professores) {
                System.out.println(p);
            }
        }
    }

    // UPDATE
    public static boolean atualizarProfessor(int id, String novoNome, String novaFormacao) {
        Professor prof = buscarProfessorPorId(id);
        if (prof != null) {
            prof.setNome(novoNome);
            prof.setFormacao(novaFormacao);
            System.out.println("Professor atualizado.");
            return true;
        }
        return false;
    }


    // DELETE
    public static boolean removerProfessor(int id) {
        Professor prof = buscarProfessorPorId(id);
        if (prof != null) {
            professores.remove(prof);
            System.out.println("Professor removido.");
            return true;
        }
        return false;
    }
}
