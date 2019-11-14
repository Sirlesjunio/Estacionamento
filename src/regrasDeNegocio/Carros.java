
package regrasDeNegocio;

public class Carros {
    private int  idcarro; 
    private String modelo; 
    private String placa; 

    public int getIdcarro() {
        return idcarro;
    }
    
    //GET para trabalhar com os frames
    public String getIdcarroStr(){
        return String.valueOf(idcarro); 
    }

    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
    }
   //sobrecarga para trabalhar com os frames
    public void setIdcarro(String idcarro) {
        this.idcarro = Integer.parseInt(idcarro);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
