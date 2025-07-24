package Controllers;

import Classes.Aluno;
import java.util.ArrayList;
import java.util.List;

public class controllerAluno {
    private static List<Aluno> alunos = new ArrayList<>();


    public static void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado com sucesso!");
    }


    public static Aluno buscarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) return aluno;
        }
        return null;
    }

    public static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno a : alunos) {
                System.out.println(a);
            }
        }
    }


    public static boolean atualizarAluno(int id, String novoNome, String novoCurso) {
        Aluno aluno = buscarAlunoPorId(id);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setCurso(novoCurso);
            System.out.println("Aluno atualizado.");
            return true;
        }
        return false;
    }


    public static boolean removerAluno(int id) {
        Aluno aluno = buscarAlunoPorId(id);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno removido.");
            return true;
        }
        return false;
    }
}
