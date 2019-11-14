package regrasDeNegocio;

public class CarroEstacionado {
    private int idEstacionado; 
    private String dataEntrada; 
    private String dataSaida; 
    private int idPreco; 
    private int idCarro; 
    private int idVaga; 

    public int getIdEstacionado() {
        return idEstacionado;
    }
    
    public String getIdEstacionadoStr() {
        return String.valueOf(this.idEstacionado);
    }

    public void setIdEstacionado(int idEstacionado) {
        this.idEstacionado = idEstacionado;
    }
    
    public void setIdEstacionado(String idEstacionado) {
        this.idEstacionado = Integer.parseInt(idEstacionado);
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = converteData(dataEntrada);
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = converteData(dataSaida);
    }

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

    public int getIdCarro() {
        return idCarro;
    }
    
    public String getIdCarroStr() {
        return String.valueOf(this.idCarro);
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }
    
     public void setIdCarro(String idCarro) {
        this.idCarro = Integer.parseInt(idCarro);
    }

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