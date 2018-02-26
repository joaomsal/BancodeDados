package DAO;

import Beans.Usuario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UsuarioDAO {
    private Connection con= null;
    
        public UsuarioDAO (){
            con = new Conexao().Conect();
        }
        
        public boolean insert (Usuario user){
  
        try { 
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Usuario (Cpf_user,Nome_user, Rg_user, email_user,telefone_user,DATANAC_USER) VALUES(?,?,?,?,?,'2001-01-01')");
            stmt.setString(1, user.getCpf_user());
            stmt.setString(2, user.getRg_user());
            stmt.setString(3, user.getEmail_user());
            stmt.setString(4, user.getTelefone_user());
            stmt.setString(5, user.getNome_user());
         //   stmt.setDate(5, user.getDataNasc_user());
            stmt.executeUpdate();
            System.out.println("salvo");
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO -> "+ex.getMessage() );
            System.out.println("Não salvo");
            return false;
        } }
        
            public void ConsultaUserP(Connection con, JTable tabela){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT nome_user,cpf_user,rg_user, email_user, telefone_user, logradouro,bairro,"+ 
                        "num,cidade FROM USUARIO NATURAL JOIN RESIDE_EM  NATURAL JOIN  ENDERECO");
                //int i=0;
                    DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                    dfm.setNumRows(0);
                        while (rs.next()){
                             //   for (int i = 0; i< rs.getRow(); i++) {
                                dfm.addRow(new Object[]{
                                    rs.getString("nome_user"),
                                    rs.getString("cpf_user"),
                                    rs.getString("rg_user"),
                                    rs.getString("email_user"),
                                    rs.getString("telefone_user"),
                                    rs.getString("logradouro"),
                                    rs.getString("bairro"),
                                    rs.getString("num"),
                                    rs.getString("cidade")});} 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }
            public void Consulta(Connection con, JTable tabela){
        try {
               Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,RESIDE_EM_ID_RESIDE) VALUES ('ooi','11','1','2010-10-10', 1)");/* +
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua',1,'bairro1','cidade1','estado1','cep1');" +
"INSERT INTO reside_em (endereco_id) values (1)");
               INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,RESIDE_EM_ID_RESIDE) VALUES ('ooi','11','1','2010-10-10', 1)*/
                ResultSet rs = stmt.executeQuery("SELECT LOGRADOURO, NUM, BAIRRO, CIDADE, ESTADO, CEP FROM APP.ENDERECO");
                  while (rs.next()){
                             DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                                dfm.setNumRows(0);
                                //for (Aluno a : alu) {
                                dfm.addRow(new Object[]{
                                    rs.getString("logradouro"),
                                    rs.getString("num"),
                                    rs.getString("bairro"),
                                    rs.getString("cidade"),
                                    rs.getString("estado"),
                                   // rs.getString("cep"),
                                   // rs.getString("bairro"),
                                   // rs.getString("num"),
                                    rs.getString("cep")});
       // }
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }
}
