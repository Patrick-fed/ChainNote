package model;

public class Bloco {
    private int id;
    private Object conteudo;
    private int timeStamp;
    private String HashAnterior;
    private String HashBloco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getConteudo() {
        return conteudo;
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    public String getHashAnterior() {
        return HashAnterior;
    }

    public void setHashAnterior(String hashAnterior) {
        HashAnterior = hashAnterior;
    }

    public String getHashBloco() {
        return HashBloco;
    }

    public void setHashBloco(String hashBloco) {
        HashBloco = hashBloco;
    }
}
