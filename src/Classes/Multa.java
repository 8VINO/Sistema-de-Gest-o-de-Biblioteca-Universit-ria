package Classes;

public class Multa {
    private static int proximoId = 1;
    private int idMulta;
    private int matriculaUsuario;
    private int tomboLivro;
    private double valor;
    private boolean pago;

    public Multa(int matriculaUsuario,int tomboLivro,double valor, boolean pago){
        this.idMulta = proximoId++;
        this.matriculaUsuario=matriculaUsuario;
        this.tomboLivro=tomboLivro;
        this.valor=valor;
        this.pago=pago;
    }

    public void setPago(){
        this.pago=true;
    }
    public int getIdMulta() {
        return idMulta;
    }

    public int getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public int getTomboLivro() {
        return tomboLivro;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

}
