package dao;

import conexoes.ConexaoMysql;
import java.sql.*; 
import regrasDeNegocio.Preco;

public class PrecoDao {
    private ConexaoMysql conex = new ConexaoMysql(); 
    private PreparedStatement stm;  
    private ResultSet rsDados; 
    private Connection con = null;
    
    public void cadastrarCarros(Preco p){
        String sql = "INSERT INTO preco (valor,dataAtualizacao,observacao) values (?,?,?);"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {
          conex.conectar();
          con = conex.getConn();   
          stm = con.prepareStatement(sql);
          stm.setString(1, p.getValorStr());
          stm.setString(2, p.getDataAtualizacao());
          stm.setString(3, p.getObservacao());
          stm.execute();
          ms.informacao("CADASTRADO COM SUCESSO!");
          stm.close();
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }   
    }
    
    public void editar(Preco p){
        String sql = "update preco set valor =?,dataAtualizacao =? where idPreco=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {    
            stm = con.prepareStatement(sql);
            stm.setString(1, p.getValorStr());
            stm.setString(2, p.getDataAtualizacao());
            stm.setString(3, p.getObservacao());
            stm.setString(4, p.getIdPrecoStr());
            stm.execute();
            stm.close();
            ms.informacao("ALTERADO COM SUCESSO");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletar(Preco p){
        String sql = "delete from preco where idPreco=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try{
           stm = con.prepareStatement(sql); 
           stm.setString(1, p.getIdPrecoStr());
           stm.execute(); 
           stm.close();
           ms.informacao("DELETADO COM SUCESSO");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void carregarDados() { //carregar dados no SET
        String sql = "select * from preco";
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
    
    public Preco getPreco() {
        Preco p = new Preco();
        try {
              p.setIdPreco(rsDados.getString("idPreco"));
              p.setValor(rsDados.getString("valor"));
              p.setDataAtualizacao(rsDados.getString("dataAtaualizacao"));
              p.setObservacao(rsDados.getString("observacao"));
        } catch (Exception e) {   
            throw new RuntimeException(e);
        }
        return p;
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
