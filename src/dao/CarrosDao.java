package dao;
import java.sql.*; 
import conexoes.ConexaoMysql; 
import regrasDeNegocio.Carros; 

public class CarrosDao {
    private ConexaoMysql conex = new ConexaoMysql(); 
    private PreparedStatement stm;  
    private ResultSet rsDados; 
    private Connection con = null;
    
    public void cadastrarCarros(Carros c){
        String sql = "INSERT INTO carros (modelo,placa) values (?,?);"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {
          conex.conectar();
          con = conex.getConn();   
          stm = con.prepareStatement(sql);
          stm.setString(1, c.getModelo());
          stm.setString(2, c.getPlaca());
          stm.execute();
          ms.informacao("CADASTRADO COM SUCESSO!");
          stm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }
    
    public void editar(Carros c){
        String sql = "update carros set modelo=?,placa =? where idcarro=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try {    
            stm = con.prepareStatement(sql);
            stm.setString(1, c.getModelo());
            stm.setString(2, c.getPlaca());
            stm.setString(3, c.getIdcarroStr());
            stm.execute();
            stm.close();
            ms.informacao("ALTERADO COM SUCESSO");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletar(Carros c){
        String sql = "delete from carros where idcarro=?"; 
        Mensagens ms = new Mensagens("ADS"); 
        try{
           stm = con.prepareStatement(sql); 
           stm.setString(1, c.getIdcarroStr());
           stm.execute(); 
           stm.close();
           ms.informacao("DELETADO COM SUCESSO");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void carregarDados() { //carregar dados no SET
        String sql = "select * from carros";
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
    
    public Carros getCarro() {
        Carros c = new Carros();
        try {
              c.setIdcarro(rsDados.getString("idcarro"));
              c.setModelo(rsDados.getString("modelo"));
              c.setPlaca(rsDados.getString("placa"));
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
    
}
