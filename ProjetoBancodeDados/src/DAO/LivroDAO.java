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
    
        
            public void ConsultaLivro(Connection con, JTable tabela){
        try {
               Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT titulo, count(exemplar.ISBN) as QUANTIDADE FROM exemplar left join titulo on exemplar.ISBN = titulo.ISBN group by titulo");
                DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                dfm.setNumRows(0);  
                while (rs.next()){
                                dfm.addRow(new Object[]{
                                    rs.getString("titulo"),
                                    rs.getString("QUANTIDADE")});
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }        
}
