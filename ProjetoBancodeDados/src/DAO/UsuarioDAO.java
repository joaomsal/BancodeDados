package DAO;

import Beans.Usuario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
}
