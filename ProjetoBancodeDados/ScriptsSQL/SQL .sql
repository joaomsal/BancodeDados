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
data_emp, Usuario_Cpf_user, ISBN, Exemplar

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
