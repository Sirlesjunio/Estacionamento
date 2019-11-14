
package conexoes;
import dao.Mensagens;
import java.sql.*;

public class ConexaoMysql {
    private Connection con;
    private String url="jdbc:mysql://localhost:3306/estacionamentobd";
    private String usuario="root";
    private String senha="root";
 
    public void conectar() {
        Mensagens ms = new Mensagens("IFRO"); 
        try {
          Class.forName("com.mysql.jdbc.Driver"); 
          this.con =DriverManager.getConnection(url,usuario,senha);      
        } catch (Exception e) {
            ms.erro("A conexão falhou!!!   "+e);
        }   
    }
    
    public Connection getConn(){
        return con;
    }
}
