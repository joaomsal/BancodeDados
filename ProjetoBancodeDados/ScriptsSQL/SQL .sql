-- Script SQL - Sistema Bibliotecário
-- Banco de Dados
-- CRIAÇÃO DAS TABELAS 

CREATE TABLE Endereco (
  Logradouro VARCHAR(40) NOT NULL,
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  num INT NOT NULL,
  bairro VARCHAR(45) NOT NULL ,
  cidade VARCHAR(45) NOT NULL,
  estado VARCHAR(45) NOT NULL,
  cep VARCHAR(45) NOT NULL ,
  UNIQUE (num,bairro,logradouro),
  PRIMARY KEY (id)
); 



CREATE TABLE Usuario (
  Cpf_user VARCHAR(15) NOT NULL,
  Nome_user VARCHAR(45) NOT NULL ,
  Rg_user VARCHAR(15) NOT NULL,
  email_user VARCHAR(45),
  telefone_user VARCHAR(45),
  dataNac_user DATE NOT NULL,
  mora INT NOT NULL,
  PRIMARY KEY (Cpf_user),  CONSTRAINT fk_Usuario_Endereco1
    FOREIGN KEY (mora)
    REFERENCES Endereco(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE Titulo (
  Titulo VARCHAR(45) NOT NULL ,
  ISBN VARCHAR(45) NOT NULL ,
  anoPub VARCHAR(6) NOT NULL ,
  Editora_obra VARCHAR(45) NOT NULL ,
  autor VARCHAR(45) NOT NULL,
  PRIMARY KEY (ISBN));


CREATE TABLE Exemplar (
  Cod INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100, INCREMENT BY 100),
  Edicao INT NOT NULL,
  Origem VARCHAR(45) NOT NULL ,
  Status VARCHAR(45) NOT NULL DEFAULT 'DISPONIVEL',
  ISBN VARCHAR(45) NOT NULL,
  PRIMARY KEY (Cod),
  CONSTRAINT fk_Exemplar_Titulo1
    FOREIGN KEY (ISBN)
    REFERENCES Titulo (ISBN)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE Emprestimo (
  data_emp DATE NOT NULL,
  id_emp INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  Usuario_Cpf_user VARCHAR(15) NOT NULL,
   ISBN VARCHAR (45) NOT NULL,
    Exemplar INT NOT NULL,
  PRIMARY KEY (id_emp, Usuario_Cpf_user),
  CONSTRAINT fk_Emprestimo_Usuario1
    FOREIGN KEY (Usuario_Cpf_user)
    REFERENCES Usuario (Cpf_user)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION ,   
    CONSTRAINT fk_Emprestimo_Titulo1
    FOREIGN KEY (ISBN)
    REFERENCES Titulo(ISBN)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT fk_Emprestimo_Exemplar1
    FOREIGN KEY (Exemplar)
    REFERENCES Exemplar(Cod)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 
-- CONSULTAS 
SELECT nome_user,cpf_user,rg_user, email_user, telefone_user, logradouro,bairro,num,cidade FROM USUARIO INNER JOIN ENDERECO ON (mora = id) where lower(nome_user) like lower('%?%');
select emprestimo.data_emp, usuario.nome_user,titulo.titulo,titulo.autor,titulo.ISBN from emprestimo  inner join usuario on cpf_user = usuario_cpf_user inner join titulo on emprestimo.isbn = titulo.isbn where lower(nome_user) like lower('%?%');
select nome_user,count(exemplar) as qt from usuario as u inner join emprestimo as e on u.CPF_USER= e.USUARIO_CPF_USER  where lower(nome_user) like lower('%?%') group by nome_user;
select nome_user,count(exemplar) as qt from usuario as u inner join emprestimo as e on u.CPF_USER= e.USUARIO_CPF_USER group by nome_user having count(exemplar)>=?;
SELECT titulo, count(exemplar.ISBN) as QUANTIDADE FROM exemplar left join titulo on exemplar.ISBN = titulo.ISBN where lower(titulo) like lower('%?%') group by titulo;
SELECT isbn, titulo,autor, editora_obra, anopub from titulo where lower(titulo) like lower('%?%');
SELECT isbn, titulo,autor, editora_obra, anopub from titulo where lower(autor) like lower('%?%');
SELECT cod,titulo,autor, edicao,anoPub, status  FROM EXEMPLAR INNER JOIN TITULO ON TITULO.ISBN = EXEMPLAR.ISBN where lower(titulo) like lower('%%');
select cod, exemplar.isbn,titulo.TITULO,titulo.AUTOR,titulo.EDITORA_OBRA,titulo.anoPub from exemplar inner join titulo on titulo.ISBN = exemplar.ISBN where status = 'DISPONIVEL' and lower(titulo) like lower('%?%');
select cod, exemplar.isbn,titulo.TITULO,titulo.AUTOR,titulo.EDITORA_OBRA,titulo.anoPub from exemplar inner join titulo on titulo.ISBN = exemplar.ISBN where status != 'DISPONIVEL' and lower(titulo) like lower('%?%');
select titulo,autor,cod,editora_obra,status,anoPub from titulo as t natural join exemplar as e where lower(titulo) like lower('%?%'); 

-- INSERÇÂO DE DADOS ESTÀ NA CLASSE  Inseredados no pacote DAO