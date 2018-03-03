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
        
            public void ConsultaUserP(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT nome_user,cpf_user,rg_user, email_user, telefone_user, logradouro,bairro,"+ 
                        "num,cidade FROM USUARIO INNER JOIN ENDERECO ON (mora = id) where lower(nome_user) like lower('%"+consulta+"%')");
                    DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                    dfm.setNumRows(0);
                        while (rs.next()){
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
            public void ConsultaEmp(Connection con, JTable tabela,String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select emprestimo.data_emp, usuario.nome_user,titulo.titulo,titulo.autor,titulo.ISBN from emprestimo  inner join usuario on cpf_user = usuario_cpf_user inner join titulo on emprestimo.isbn = titulo.isbn where lower(nome_user) like lower('%"+consulta+"%')");
                             DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                                dfm.setNumRows(0);
                  while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getString("nome_user"),
                                    rs.getString("data_emp"),
                                    rs.getString("titulo"),
                                    rs.getString("autor"),
                                    rs.getString("isbn")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }
}
