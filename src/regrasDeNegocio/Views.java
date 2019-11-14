package regrasDeNegocio;

public class Views {

    private int idEstacionado;
    private int idCarro;
    private int idVaga;
    private String modelo;
    private String placa;
    private int numero_Vaga;
    private String entrada;
    private String hora_entrada;
    private String saida;
    private String hora_saida;
    private float valor_por_minuto;
    private float total;

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

    public int getNumero_Vaga() {
        return numero_Vaga;
    }

    public String getNumero_VagaStr() {
        return String.valueOf(this.numero_Vaga);
    }

    public void setNumero_Vaga(int numero_Vaga) {
        this.numero_Vaga = numero_Vaga;
    }

    public void setNumero_Vaga(String numero_Vaga) {
        this.numero_Vaga = Integer.parseInt(numero_Vaga);
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(String hora_saida) {
        this.hora_saida = hora_saida;
    }

    public float getValor_por_minuto() {
        return valor_por_minuto;
    }

    public String getValor_por_minutoStr() {
        return String.valueOf(valor_por_minuto);
    }

    public void setValor_por_minuto(float valor_por_minuto) {
        this.valor_por_minuto = valor_por_minuto;
    }

    public void setValor_por_minuto(String valor_por_minuto) {
        this.valor_por_minuto = Float.parseFloat(valor_por_minuto);
    }

    public float getTotal() {
        return total;
    }

    public String getTotalStr() {
        return String.valueOf(this.total);
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setTotal(String total) {
        if (total == null) {
            total = "0";
        }
        this.total = Float.parseFloat(total);
    }

    public int getIdEstacionado() {
        return idEstacionado;
    }
    
    public String getIdEstacionadoStr() {
        return String.valueOf(idEstacionado);
    }

    public void setIdEstacionado(int idEstacionado) {
        this.idEstacionado = idEstacionado;
    }
    
    public void setIdEstacionado(String idEstacionado) {
        this.idEstacionado = Integer.parseInt(idEstacionado);
    }

    public int getIdCarro() {
        return idCarro;
    }

    public String getIdCarroStr() {
        return String.valueOf(idCarro);
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
        return String.valueOf(idVaga);
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = Integer.parseInt(idVaga);
    }

}
