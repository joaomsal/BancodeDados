
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {
    Connection con = null;
    
    
    public Connection CreateDB(){
        try { // Criação do banco de dados 
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             con = DriverManager.getConnection("jdbc:derby:.\\DataBase\\Derby.DB;create = true");
                
                if(con!=null){
                    JOptionPane.showMessageDialog(null, "BANCO DE DADOS CRIADO!");
                    
                    // Scripts de criação das tabelas !
                    String createEnd = "CREATE TABLE Endereco (" +
"  Logradouro VARCHAR(40) NOT NULL," +
"  id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
"  num INT NOT NULL," +
"  bairro VARCHAR(45) NOT NULL ," +
"  cidade VARCHAR(45) NOT NULL," +
"  estado VARCHAR(45) NOT NULL," +
"  cep VARCHAR(45) NOT NULL ," +
"  PRIMARY KEY (id))";
                    String createRes = "CREATE TABLE Reside_em (" +
"  Endereco_id INT NOT NULL ," +
"  id_reside INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
"  PRIMARY KEY (id_reside)," +
"  CONSTRAINT fk_Reside_em_Endereco" +
"    FOREIGN KEY (Endereco_id)" +
"    REFERENCES Endereco (id)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" ;
                    String createUs ="CREATE TABLE Usuario (" +
"  Cpf_user VARCHAR(15) NOT NULL," +
"  Nome_user VARCHAR(45) NOT NULL ," +
"  Rg_user VARCHAR(15) NOT NULL," +
"  email_user VARCHAR(45)," +
"  telefone_user VARCHAR(45)," +
"  dataNac_user DATE NOT NULL," +
"  Reside_em_id_reside INT NOT NULL," +
"  PRIMARY KEY (Cpf_user),  CONSTRAINT fk_Usuario_Reside_em1" +
"    FOREIGN KEY (Reside_em_id_reside)" +
"    REFERENCES Reside_em (id_reside)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)";
                    String createEmp="CREATE TABLE Emprestimo (" +
"  data_emp DATE NOT NULL," +
"  id_emp INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
"  Usuario_Cpf_user VARCHAR(15) NOT NULL," +
"   ISBN VARCHAR (45) NOT NULL," +
"    Exemplar INT NOT NULL," +
"  PRIMARY KEY (id_emp, Usuario_Cpf_user)," +
"  CONSTRAINT fk_Emprestimo_Usuario1" +
"    FOREIGN KEY (Usuario_Cpf_user)" +
"    REFERENCES Usuario (Cpf_user)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION ," +
"    CONSTRAINT fk_Emprestimo_Titulo1" +
"    FOREIGN KEY (ISBN)" +
"    REFERENCES Titulo(ISBN)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"    CONSTRAINT fk_Emprestimo_Exemplar1" +
"    FOREIGN KEY (Exemplar)" +
"    REFERENCES Exemplar(Cod)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)";
                    String createTit="CREATE TABLE Titulo (" +
"  Titulo VARCHAR(45) NOT NULL ," +
"  ISBN VARCHAR(45) NOT NULL ," +
"  anoPub VARCHAR(6) NOT NULL ," +
"  Editora_obra VARCHAR(45) NOT NULL ," +
"  autor VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (ISBN))";
                    String createEx = "CREATE TABLE Exemplar (" +
"  Cod INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 100)," +
"  Edicao INT NOT NULL," +
"  Origem VARCHAR(45) NOT NULL ," +
"  Status VARCHAR(45) NOT NULL DEFAULT 'DISPON�VEL'," +
"  ISBN VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (Cod)," +
"  CONSTRAINT fk_Exemplar_Titulo1" +
"    FOREIGN KEY (ISBN)" +
"    REFERENCES Titulo (ISBN)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)";
                   
                    
                       try { // Criação das Tabelas
                        PreparedStatement stmt = con.prepareStatement(createEnd);
                        stmt.execute();
                        stmt.close();
                        PreparedStatement stmt1 = con.prepareStatement(createRes);
                        stmt1.execute();
                        stmt1.close();
                        PreparedStatement stmt2 = con.prepareStatement(createUs);
                        stmt2.execute();
                        stmt2.close();
                        PreparedStatement stmt3 = con.prepareStatement(createTit);
                        stmt3.execute();
                        stmt3.close();
                        PreparedStatement stmt4 = con.prepareStatement(createEx);
                        stmt4.execute();
                        stmt4.close();
                        PreparedStatement stmt5 = con.prepareStatement(createEmp);
                        stmt5.execute();
                        stmt5.close();
                           System.out.println("CRIOU!!!");
                      Close();
                        JOptionPane.showMessageDialog(null, "TABELA CRIADA!");
                       }catch(SQLException e){
                        JOptionPane.showMessageDialog(null," Erro Tabela -  "+ e.getLocalizedMessage());   
                       }
                       
                       }          
        } catch (ClassNotFoundException | SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return con;
    }
    
    public Connection Conect(){
        try { // Conexão com o banco criado
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby:.\\DataBase\\Derby.DB");
                if(con != null){
                     JOptionPane.showMessageDialog(null, "CONECTADO!");
                }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO"+ex.getMessage());
        }
        return con;
    }
    
    public void Close(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro"+ ex.getLocalizedMessage());
        }
    }

}
