package dao;

import conexoes.ConexaoMysql;
import java.sql.*;
import regrasDeNegocio.Views;

public class ViewsDao {
    private ConexaoMysql conex = new ConexaoMysql(); 
    private PreparedStatement stm;  
    private ResultSet rsDados; 
    private Connection con = null;
  
    public void consultarContasAbertas() { //carregar dados no SET
        String sql = "select * from conta_aberta";
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
    
    public void localizarContasAbertas(String placa) { 
        String sql = "select * from conta_aberta where placa = '"+placa+"'";
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
    
    public void consultarContasFechadas() { //carregar dados no SET
        String sql = "select * from conta_fechada";
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
    
    public Views getResultado() {
        Views v = new Views();
        try {
              v.setIdEstacionado(rsDados.getString("idestacionado"));
              v.setIdCarro(rsDados.getString("idCarro"));
              v.setIdVaga(rsDados.getString("idVaga"));
              v.setModelo(rsDados.getString("modelo"));
              v.setPlaca(rsDados.getString("placa"));
              v.setNumero_Vaga(rsDados.getString("numero_vaga"));
              v.setEntrada(rsDados.getString("entrada"));
              v.setHora_entrada(rsDados.getString("hora_entrada"));
              v.setSaida(rsDados.getString("saida"));
              v.setHora_saida(rsDados.getString("hora_saida"));
              v.setValor_por_minuto(rsDados.getString("valor_por_minuto"));
              v.setTotal(rsDados.getString("total"));
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

