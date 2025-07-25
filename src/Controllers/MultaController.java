package Controllers;

import Classes.Multa;
import Classes.Emprestimo;
import Classes.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MultaController {
    private List<Multa> multas;
    private static final double VALOR_PADRAO = 10.0;

    public MultaController() {
        this.multas = new ArrayList<>();
    }

    public int verificarEAtribuirMulta(List<Emprestimo> emprestimos, Usuario usuario) {
        int count = 0;
        LocalDate hoje = LocalDate.now();

        for (Emprestimo e : emprestimos) {
            if (e.getMatriculaUsuario() == usuario.getMatricula()
                    && e.getPrazoDevolucao().isBefore(hoje)
                    && !existeMultaPara(usuario.getMatricula(), e.getTomboLivro())) {

                Multa m = new Multa(usuario.getMatricula(), e.getTomboLivro(), VALOR_PADRAO, false);
                multas.add(m);
                count++;
            }
        }
        return count;
    }

    private boolean existeMultaPara(int matriculaUsuario, int tomboLivro) {
        for (Multa m : multas) {
            if (m.getMatriculaUsuario() == matriculaUsuario && m.getTomboLivro() == tomboLivro && !m.isPago()) {
                return true;
            }
        }
        return false;
    }


    public void pagarMulta(int idMulta) {
        for (Multa m : multas) {
            if (m.getIdMulta() == idMulta) {
                if (m.isPago()) {
                    System.out.println("Essa multa já está paga.");
                } else {
                    m.setPago();
                    System.out.println("Multa ID " + idMulta + " paga com sucesso.");
                }
                return;
            }
        }
        System.out.println("Multa não encontrada.");
    }

    public List<Multa> getMultasDoUsuario(Usuario usuario) {
        List<Multa> resultado = new ArrayList<>();
        for (Multa m : multas) {
            if (m.getMatriculaUsuario() == usuario.getMatricula()) {
                resultado.add(m);
            }
        }
        return resultado;
    }

}
