package dao;

import conexoes.ConexaoMysql;
import java.sql.*;
import regrasDeNegocio.Vagas;

public class VagasDao {
    private ConexaoMysql conex = new ConexaoMysql(); 
    private PreparedStatement stm;  
    private ResultSet rsDados; 
    private Connection con = null;
    
    public void cadastrarCarros(Vagas v){
        String sql = "INSERT INTO vagas (numero,ocupado) values (?,?);"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {
          conex.conectar();
          con = conex.getConn();   
          stm = con.prepareStatement(sql);
          stm.setString(1, v.getNumeroStr());
          stm.setString(2, v.getOcupado());
          stm.execute();
          ms.informacao("CADASTRADO COM SUCESSO!");
          stm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }
    
    public void editar(Vagas v){
        String sql = "update vagas set numero=?,ocupado =? where idVaga=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {    
            stm = con.prepareStatement(sql);
            stm.setString(1, v.getNumeroStr());
            stm.setString(2, v.getOcupado());
            stm.setString(3, v.getIdVagaStr());
            stm.execute();
            stm.close();
            ms.informacao("ALTERADO COM SUCESSO");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletar(Vagas v){
        String sql = "delete from vagas where idcarro=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try{
           stm = con.prepareStatement(sql); 
           stm.setString(1, v.getIdVagaStr());
           stm.execute(); 
           stm.close();
           ms.informacao("DELETADO COM SUCESSO");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void carregarDados() { //carregar dados no SET
        String sql = "select * from vagas";
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
    
    public Vagas getVaga() {
        Vagas v = new Vagas();
        try {
              v.setIdVaga(rsDados.getString("idVaga"));
              v.setNumero(rsDados.getString("numero"));
              v.setOcupado(rsDados.getString("ocupado"));
        } catch (Exception e) {   
            throw new RuntimeException(e);
        }
        return v;
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
    
}
