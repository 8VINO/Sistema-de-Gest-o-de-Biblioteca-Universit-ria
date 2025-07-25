package Classes;

public class Multa {
    private static int proximoId = 1;
    private int idMulta;
    private String cpfUsuario;
    private int tomboLivro;
    private double valor;
    private boolean pago;

    public Multa(String cpfUsuario,int tomboLivro,double valor, boolean pago){
        this.idMulta = proximoId++;
        this.cpfUsuario=cpfUsuario;
        this.tomboLivro=tomboLivro;
        this.valor=valor;
        this.pago=pago;
    }

    public void setPago(){
        this.pago=true;
    }
}
