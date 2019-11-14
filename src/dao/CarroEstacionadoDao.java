package dao;

import conexoes.ConexaoMysql;
import java.sql.*; 
import regrasDeNegocio.CarroEstacionado;

public class CarroEstacionadoDao {
    private ConexaoMysql conex = new ConexaoMysql(); 
    private PreparedStatement stm;  
    private ResultSet rsDados; 
    private Connection con = null;

    
    public void cadastrarCarros(CarroEstacionado c){
        String sql = "INSERT INTO carroestacionado (idVaga, idCarro,dataEntrada,dataSaida) values (?,?,?,?);"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {
          conex.conectar();
          con = conex.getConn();   
          stm = con.prepareStatement(sql);
          stm.setString(1, c.getIdVagaStr());
          stm.setString(2, c.getIdCarroStr());
          stm.setString(3, c.getDataEntrada());
          stm.setString(4, c.getDataSaida());
          stm.execute();
          ms.informacao("CADASTRADO COM SUCESSO!");
          stm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }
     
    public void deletar(CarroEstacionado c){
        String sql = "delete from CarroEstacionado where idEstacionado=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try{
           stm = con.prepareStatement(sql); 
           stm.setString(1, c.getIdEstacionadoStr());
           stm.execute(); 
           stm.close();
           ms.informacao("DELETADO COM SUCESSO");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void carregarDados() { //carregar dados no SET
        String sql = "select * from CarroEstacionado";
        Statement st; 
        try {
          conex.conectar();
          con = conex.getConn(); 
          int x = ResultSet.TYPE_SCROLL_SENSITIVE; //permitir a navegação(1005)
          int y = ResultSet.CONCUR_UPDATABLE; //permitir a edição(1008)
          stm = con.prepareStatement(sql,x,y);
          rsDados= stm.executeQuery();
         
        } catch (Exception e) {   
            throw new RuntimeException(e);
        }
    }
    
    public CarroEstacionado getRegistro() {
        CarroEstacionado c = new CarroEstacionado();
        try {
              c.setIdEstacionado(rsDados.getString("idEstacionado"));
              c.setDataEntrada(rsDados.getString("dataEntrada"));
              c.setDataSaida(rsDados.getString("dataSaida"));
              c.setIdPreco(rsDados.getString("idPreco"));
              c.setIdCarro(rsDados.getString("idCarro"));
              c.setIdVaga(rsDados.getString("idVaga"));
        } catch (Exception e) {   
            throw new RuntimeException(e);
        }
        return c;
    }
    
    
    public boolean proximo(){
         boolean fim; 
         try {
          fim = !rsDados.isLast();   
          if (fim) rsDados.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
        return fim;  
    } 
    
    public boolean anterior(){
        boolean inicio; 
         try {
           inicio = !rsDados.isFirst(); 
           if (inicio) rsDados.previous();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inicio;  
    }
    
    public void ultimo(){
         try {    
           rsDados.last();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void primeiro(){
        try {    
           rsDados.first(); 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void liberarVaga(CarroEstacionado c){
        
        String sql = "update carroestacionado set dataSaida=? where idEstacionado=?";
        Mensagens ms = new Mensagens("ADS");
        
        try{
            conex.conectar();
            con = conex.getConn();
            stm=con.prepareStatement(sql);
            stm.setString(1, c.getDataSaida());
            stm.setString(2, c.getIdEstacionadoStr());
            stm.execute();
            stm.close();
            ms.informacao("VAGA LIBERADA COM SUCESSO");
            
        }catch (Exception e){
            throw new RuntimeException(e);
        }
            
    }
}
