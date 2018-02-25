package Beans;

import java.sql.Date;

public class Emprestimo {
    private String Usuario_cpf_user;
    private Date data_emp;
    public Date getData_emp() {
        return data_emp;
    }

    public void setData_emp(Date data_emp) {
        this.data_emp = data_emp;
    }

    public String getUsuario_cpf_user() {
        return Usuario_cpf_user;
    }

    public void setUsuario_cpf_user(String Usuario_cpf_user) {
        this.Usuario_cpf_user = Usuario_cpf_user;
    }
}
