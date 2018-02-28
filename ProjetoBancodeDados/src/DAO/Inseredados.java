package DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Inseredados {
    private Connection con = null;
    
        public Inseredados(){
            con = new Conexao().Conect();
        }
    
    public void insere(){
        try {
            Statement stmt = con.createStatement();
            //String [] query = sql.split(";");
            for (int i = 0; i< sql1.length; i++){
            stmt.executeUpdate(sql1[i]);
                System.out.println(sql1[i]);}
            System.out.println("criou");
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERRO INSERIR  -  "+ ex.getLocalizedMessage());
        }
    }
    
    String [] sql = {"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua lagarto',101,'centro','aracaju','se','4900-0101')",
"INSERT INTO reside_em (endereco_id) values (1)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,RESIDE_EM_ID_RESIDE) VALUES ('Kakashi','10101010','11111100','2000-10-10', 1)",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Banco de dados','010101013', '2001','Editora C', 'André Backes')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'doação','010101013')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua acre',2,'centro','aracaju','SE','4900-000')" ,
"INSERT INTO emprestimo (data_emp, usuario_cpf_user, isbn, exemplar) values ('2018-02-01','10101010','010101013',100)",

"INSERT INTO reside_em (endereco_id) values (2)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,RESIDE_EM_ID_RESIDE) VALUES ('Maria de Fátima','1010101','11111','1980-10-10', 2)",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Cálculo','010101012', '2011','Editora C', 'James Stwart')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','010101012')" ,
"INSERT INTO emprestimo (data_emp, usuario_cpf_user, isbn, exemplar) values ('2018-02-01','1010101','010101012',200)" ,
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua paraná',201,'São Jorge','Aracaju','SE','4901-000')" ,
"INSERT INTO reside_em (endereco_id) values (3)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,RESIDE_EM_ID_RESIDE) VALUES ('José Da Silva','101012','111112','1975-12-13', 3)", 
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Vetores e Geometria Analitica','01010102', '2002','Editora C', 'Reis & Silva')",
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (5,'doação','010101012')" ,
"INSERT INTO emprestimo (data_emp, usuario_cpf_user, isbn, exemplar) values ('2017-11-01','101012','010101012',300)"};
String [] sql1 = {"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua B',209,'centro','aracaju','SE','4900-000')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua D',219,'São José','aracaju','SE','49100-000')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('rua A',222,'Jabutiana','Aracaju','SE','49100-020')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Rua Estância',212,'Centro','Aracaju','SE','49110-020')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Rua Estância',210,'Centro','Aracaju','SE','49110-020')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Rua Lagarto',21,'Centro','Aracaju','SE','49110-021')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Avenida Hermes Fones',211,'Jardins','Aracaju','SE','49110-001')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Rua Gurijim',210,'Rosa Elze','São Cristóvão','SE','49110-111')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Avenida da Justiça',52,'Broklyn','Metropólis','CA','49000-111')",
"INSERT INTO Endereco (logradouro,num,bairro,cidade,estado,cep) values ('Avenida das Trevas',52,'DARKSIDE','Gotham','CA','49521-111')",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Ingryd Santos','10301012','1173111','1997-05-08', 1)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Jose da Silva','20301012','2173111','1977-05-08', 1)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Maria dos Santos','30301012','3173111','1967-05-08', 1)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Josefa da Silva','40301012','4173111','1995-05-08', 1)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Mário Bros','45301012','4573111','1995-05-08', 2)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('André Brito','65301012','6673111','1985-10-18', 3)" ,
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Beatriz Trinchão','59301012','5973111','1989-10-18', 3)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Antônio Monteiro','89301012','6073111','1975-10-18', 4)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Maria Augusta','90301012','6173111','1985-02-18', 5)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('José Augusto','91301012','6273111','1980-02-18', 5)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Leila Maciel','91401012','6275111','1984-02-25', 6)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Carlos Maciel','91401019','7875111','1984-12-25', 6)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Carla Maciel','91403519','7896111','1997-02-01', 6)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Giovanny Lucéro','91452519','63196111','1988-08-01', 7)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Marta Lucéro','91452593','58196111','1990-07-11', 7)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Carlo Pietro','0550593','327196111','1980-09-19', 8)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Maria do Carmo','0528593','32196171','1986-10-19', 8)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Clark Kent','323214','021425','1950-12-10', 9)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Marta Kent','44323214','04021425','1930-12-10', 9)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Lois Lane','45323214','0451425','1930-11-10', 9)",
"INSERT INTO USUARIO (nome_user,cpf_user,rg_user,dataNac_user,mora) VALUES ('Bruce Wayne','45301214','78451425','1950-01-19', 10)",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Progamando JAVA','0101010120', '2011','Editora JAVA', 'DEITEL')" ,
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Cáculo','1101010120', '2018','Editora MATH', 'James Stwart')" ,
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Compiladores','5091010120', '1990','Editora COMP', 'Arthur Cury')" ,
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Gabriela','50915120', '1975','Editora Brasil', 'Jorge Amado')" ,
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('Platão','9109990', '1991','Editora Roma', 'James Gordon')" ,
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('O Envolvimento','119610120', '2018','Editora BAD', 'Loma')" ,
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('IT: Think','509101002', '1997','Editora Dark', 'Sthephen King')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','509101002')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','119610120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','119610120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','119610120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','119610120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','119610120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','9109990')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','50915120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','5091010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','0101010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Doação','0101010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Doação','1101010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010120')" ,
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','0101010120')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('GEOMETRIA ANALITICA','1101010133', '2010','Editora MATH', 'Paulo Boulos')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('VETORES & GEOMETRIA ANALITICA','1101010134', '2010','Editora MATH', 'REIS E SIVA')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('ESTRUTURA DE DADOS','1101010135', '2001','Editora COMP', 'PRESMAN')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('INTELIGÊNCIA ARTIFICIAL','1101010136', '2000','Editora COMP', 'PRESMAN')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('ENGENHARIA DE SOFTWARE','1101010137', '2010','Editora COMP', 'PRESMAN')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('TEORIA DOS GRAFOS','1101010138', '2006','Editora COMP', 'PRESMAN')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('BANCO DE DADOS ','1101010139', '1999','Editora COMP', 'PRESMAN')",
"INSERT INTO titulo (titulo,isbn,anopub,editora_obra,autor) values ('COMPUTAÇÃO GRÁFICA','1101010140', '2018','Editora COMP', 'PRESMAN')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (3,'Compra','1101010135')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'DOAÇÃO','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'DOAÇÃO','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'DOAÇÃO','1101010136')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'DOAÇÃO','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'DOAÇÃO','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010137')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (7,'Compra','1101010138')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (1,'Compra','1101010139')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')",
"INSERT INTO exemplar (edicao, origem, isbn) values (2,'Compra','1101010140')"};
    
}
