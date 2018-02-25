package Beans;

public class Exemplar {
    private String  Origem_ex, Titulo_ISBN, Status_ex;

    public String getStatus_ex() {
        return Status_ex;
    }

    public void setStatus_ex(String Status_ex) {
        this.Status_ex = Status_ex;
    }
    private int Edition_ex;

    public int getEdition_ex() {
        return Edition_ex;
    }

    public void setEdition_ex(int Edition_ex) {
        this.Edition_ex = Edition_ex;
    }

    public String getOrigem_ex() {
        return Origem_ex;
    }

    public void setOrigem_ex(String Origem_ex) {
        this.Origem_ex = Origem_ex;
    }

    public String getTitulo_ISBN() {
        return Titulo_ISBN;
    }

    public void setTitulo_ISBN(String Titulo_ISBN) {
        this.Titulo_ISBN = Titulo_ISBN;
    }
}
