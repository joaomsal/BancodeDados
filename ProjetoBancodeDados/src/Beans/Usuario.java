package Beans;

import java.sql.Date;

public class Usuario {
    private String Cpf_user, Rg_user, email_user,telefone_user,nome_user;

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }
    private Date  dataNasc_user;

    public Date getDataNasc_user() {
        return dataNasc_user;
    }

    public void setDataNasc_user(Date dataNasc_user) {
        this.dataNasc_user = dataNasc_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getCpf_user() {
        return Cpf_user;
    }

    public void setCpf_user(String Cpf_user) {
        this.Cpf_user = Cpf_user;
    }

    public String getRg_user() {
        return Rg_user;
    }

    public void setRg_user(String Rg_user) {
        this.Rg_user = Rg_user;
    }

    public String getTelefone_user() {
        return telefone_user;
    }

    public void setTelefone_user(String telefone_user) {
        this.telefone_user = telefone_user;
    }

}
