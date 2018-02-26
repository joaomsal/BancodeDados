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
               stmt.executeUpdate("INSERT INTO titulo (titulo,isbn,anopub,editore_obra,autor) values ('C completo total','01010101', '2001','Editora C', 'André Backes')");
               stmt.executeUpdate("INSERT INTO exemplar (edition_ex, origem_ex, status_ex, titulo_isbn) values (2,'doação','disponível','01010101')");
               stmt.executeUpdate("INSERT INTO emprestimo (data_emp, Usuario_Cpf_user) values ('2018-02-01','11')");
                ResultSet rs = stmt.executeQuery("SELECT nome_user,cpf_user,rg_user, email_user, telefone_user, logradouro,bairro,"+ 
                        "num,cidade FROM USUARIO NATURAL JOIN RESIDE_EM  NATURAL JOIN  ENDERECO");
                  while (rs.next()){
                             DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
                                dfm.setNumRows(0);
                                //for (Aluno a : alu) {
                                dfm.addRow(new Object[]{
                                    rs.getString("nome_user"),
                                    rs.getString("cpf_user"),
                                    rs.getString("rg_user"),
                                    rs.getString("email_user"),
                                    rs.getString("telefone_user"),
                                    rs.getString("logradouro"),
                                    rs.getString("bairro"),
                                    rs.getString("num"),
                                    rs.getString("cidade")});
       // }
                  } 
                  con.close();
                  JOptionPane.showMessageDialog(null,"ENCONTRADO!");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }   
    }        
}
