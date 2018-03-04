package DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class LivroDAO {
    private Connection con = null;

        public LivroDAO(){
            con = new Conexao().Conect();
        }
    
        
            public void ConsultaLivro(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT titulo, count(exemplar.ISBN) as QUANTIDADE FROM exemplar left join titulo on exemplar.ISBN = titulo.ISBN where lower(titulo) like lower('%"+consulta+"%') group by titulo");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getString("titulo"),
                                    rs.getString("QUANTIDADE")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"BUSCA REALIZADA COM SUCESSO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   }
            
            
            public void ConsultaSimples(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT isbn, titulo,autor, editora_obra, anopub from titulo where lower(titulo) like lower('%"+consulta+"%')");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getString("isbn"), // isbn, titulo, autor, editora, ano 
                                    rs.getString("titulo"),
                                    rs.getString("autor"),
                                    rs.getString("editora_obra"),
                                    rs.getString("anopub")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   }
            
            
            public void ConsultaPorAutor(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT isbn, titulo,autor, editora_obra, anopub from titulo where lower(autor) like lower('%"+consulta+"%')");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                        rs.getString("autor"), // AUTOR, TITULO, EDITORA, ANOPUB, ISBN
                                    rs.getString("titulo"),
                                    rs.getString("editora_obra"),
                                    rs.getString("anopub"),
                                    rs.getString("isbn")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   }
            
            
            public void ConsultaEx(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT cod,titulo,autor, edicao,anoPub, status  FROM EXEMPLAR INNER JOIN TITULO ON TITULO.ISBN = EXEMPLAR.ISBN where lower(titulo) like lower('%"+consulta+"%')");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getInt("cod"),
                                    rs.getString("titulo"),
                                    rs.getString("autor"),
                                    rs.getString("edicao"),
                                    rs.getString("anoPub"),
                                    rs.getString("status")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"BUSCA REALIZADA COM SUCESSO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   }
           
            
            public void ConsultaLivrosDisp(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select cod, exemplar.isbn,titulo.TITULO,titulo.AUTOR,titulo.EDITORA_OBRA,titulo.anoPub from exemplar inner join titulo on titulo.ISBN = exemplar.ISBN where status = 'DISPONIVEL' and lower(titulo) like lower('%"+consulta+"%') ");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    
                                    rs.getString("cod"),
                                    rs.getString("isbn"),
                                    rs.getString("titulo"),
                                    rs.getString("autor"),
                                    rs.getString("editora_obra"),
                                    rs.getString("anoPub")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"BUSCA REALIZADA COM SUCESSO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }        
            public void ConsultaLivrosInd(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select cod, exemplar.isbn,titulo.TITULO,titulo.AUTOR,titulo.EDITORA_OBRA,titulo.anoPub from exemplar inner join titulo on titulo.ISBN = exemplar.ISBN where status != 'DISPONIVEL' and lower(titulo) like lower('%"+consulta+"%') ");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getString("cod"),
                                    rs.getString("isbn"),
                                    rs.getString("titulo"),
                                    rs.getString("autor"),
                                    rs.getString("editora_obra"),
                                    rs.getString("anoPub")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"BUSCA REALIZADA COM SUCESSO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }        
            public void ConsultaLivroLike(Connection con, JTable tabela, String consulta){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select titulo,autor,cod,editora_obra,status,anoPub from titulo as t natural join exemplar as e where lower(titulo) like lower('%"+consulta+"%')");
                
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getString("cod"),
                                    rs.getString("titulo"),  // cod
                                    rs.getString("autor"),
                                    rs.getString("editora_obra"),
                                    rs.getString("anoPub"),
                                    rs.getString("status")
                                    });
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"BUSCA REALIZADA COM SUCESSO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }        
}
