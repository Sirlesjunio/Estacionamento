
package regrasDeNegocio;

public class Vagas {
    private int idVaga;
    private int numero; 
    private boolean ocupado; 

    public int getIdVaga() {
        return idVaga;
    }
    
    public String getIdVagaStr() {
        return String.valueOf(this.idVaga);
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }
    
    public void setIdVaga(String idVaga) {
        this.idVaga = Integer.parseInt(idVaga);
    }

    public int getNumero() {
        return numero;
    }
    
    public String getNumeroStr() {
        return String.valueOf(numero);
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setNumero(String numeroVaga) {
        this.numero = Integer.parseInt(numeroVaga);
    }

    public boolean isOcupado() {
        return ocupado;
    }
    
    public String getOcupado() {
        return String.valueOf(this.ocupado);
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }  
    
    public void setOcupado(String ocupado) {
        this.ocupado = Boolean.parseBoolean(ocupado);
    }
}
