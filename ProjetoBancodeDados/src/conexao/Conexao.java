
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
             con = DriverManager.getConnection("jdbc:derby:.\\DataBase\\Derby.1DB;create = true");
                
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
"  UNIQUE (num,bairro,logradouro)," +
"  PRIMARY KEY (id))";
                    
                    String createUs ="CREATE TABLE Usuario (" +
"  Cpf_user VARCHAR(15) NOT NULL," +
"  Nome_user VARCHAR(45) NOT NULL ," +
"  Rg_user VARCHAR(15) NOT NULL," +
"  email_user VARCHAR(45)," +
"  telefone_user VARCHAR(45)," +
"  dataNac_user DATE NOT NULL," +
"  mora INT NOT NULL," +
"  PRIMARY KEY (Cpf_user),  CONSTRAINT fk_Usuario_Endereco1" +
"    FOREIGN KEY (mora)" +
"    REFERENCES Endereco(id)" +
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
"    ON UPDATE NO ACTION ,   " +
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
"  Cod INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100, INCREMENT BY 100)," +
"  Edicao INT NOT NULL," +
"  Origem VARCHAR(45) NOT NULL ," +
"  Status VARCHAR(45) NOT NULL DEFAULT 'DISPONIVEL'," +
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
                        PreparedStatement stmt1 = con.prepareStatement(createUs);
                        stmt1.execute();
                        stmt1.close();
                        PreparedStatement stmt2 = con.prepareStatement(createTit);
                        stmt2.execute();
                        stmt2.close();
                        PreparedStatement stmt3 = con.prepareStatement(createEx);
                        stmt3.execute();
                        stmt3.close();
                        PreparedStatement stmt4 = con.prepareStatement(createEmp);
                        stmt4.execute();
                        stmt4.close();
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
            con = DriverManager.getConnection("jdbc:derby:.\\DataBase\\Derby.1DB");
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
