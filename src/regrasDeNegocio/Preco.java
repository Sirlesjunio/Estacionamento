package regrasDeNegocio;

public class Preco {
    private int idPreco;
    private float valor; 
    private String dataAtualizacao; 
    private String observacao; 

    public int getIdPreco() {
        return idPreco;
    }
    
    public String getIdPrecoStr() {
        return String.valueOf(this.idPreco);
    }

    public void setIdPreco(int idPreco) {
        this.idPreco = idPreco;
    }
    
     public void setIdPreco(String idPreco) {
        this.idPreco = Integer.parseInt(idPreco);
    }

    public float getValor() {
        return valor;
    }
    
    public String getValorStr() {
        return String.valueOf(this.valor);
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void setValor(String valor) {
        this.valor = Float.parseFloat(valor);
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = converteData(dataAtualizacao);
    }
    
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public String converteData(String data){
        if (data.substring(2, 3).equals("/")){
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6);
            data = ano+"-"+mes+"-"+dia;
        }else{
            String ano = data.substring(0, 4);
            String mes = data.substring(5, 7);
            String dia = data.substring(8);
            data = dia+"/"+mes+"/"+ano;
        }  
        return data; 
    }
    
}
