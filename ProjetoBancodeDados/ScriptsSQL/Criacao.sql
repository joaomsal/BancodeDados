-- Script SQL - Sistema de Biblioteca
-- Banco de Dados


CREATE TABLE Endereco (
  Logradouro VARCHAR(40) NOT NULL,
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  num INT NOT NULL,
  bairro VARCHAR(45) NOT NULL ,
  cidade VARCHAR(45) NOT NULL,
  estado VARCHAR(45) NOT NULL,
  cep VARCHAR(45) NOT NULL ,
  PRIMARY KEY (id));


CREATE TABLE Reside_em (
  Endereco_id INT NOT NULL ,
  id_reside INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  PRIMARY KEY (id_reside),
  CONSTRAINT fk_Reside_em_Endereco
    FOREIGN KEY (Endereco_id)
    REFERENCES Endereco (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE Usuario (
  Cpf_user VARCHAR(15) NOT NULL,
  Nome_user VARCHAR(45) NOT NULL ,
  Rg_user VARCHAR(15) NOT NULL,
  email_user VARCHAR(45),
  telefone_user VARCHAR(45),
  dataNac_user DATE NOT NULL,
  Reside_em_id_reside INT NOT NULL,
  PRIMARY KEY (Cpf_user),  CONSTRAINT fk_Usuario_Reside_em1
    FOREIGN KEY (Reside_em_id_reside)
    REFERENCES Reside_em (id_reside)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

--INSERT INTO emprestimo (data_emp, Usuario_Cpf_user) values ('2018-02-01','')

CREATE TABLE Titulo (
  Titulo VARCHAR(45) NOT NULL ,
  ISBN VARCHAR(45) NOT NULL ,
  anoPub VARCHAR(6) NOT NULL ,
  Editora_obra VARCHAR(45) NOT NULL ,
  autor VARCHAR(45) NOT NULL,
  PRIMARY KEY (ISBN));


--INSERT INTO titulo (titulo,isbn,anopub,editore_obra,autor) values ('C completo total','01010101', '2001','Editora C', 'André Backes')

CREATE TABLE Exemplar (
  Cod INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 100),
  Edicao INT NOT NULL,
  Origem VARCHAR(45) NOT NULL ,
  Status VARCHAR(45) NOT NULL DEFAULT 'DISPON�VEL',
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
--INSERT INTO exemplar (edition_ex, origem_ex, status_ex, titulo_isbn) values (2,'doação','disponível','01010101')


INSERT INTO emprestimo (data_emp, usuario_cpf_user, isbn, exemplar) values ('2018-02-01','','','')