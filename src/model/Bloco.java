package model;

import interfaces.Conteudo;

public class Bloco {
    private int id;
    private long timeStamp;
    private Conteudo conteudo;
    private String hashAnterior;
    private String hashBloco;

    public Bloco(int id, long timeStamp, Conteudo conteudo, String hashAnterior) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.conteudo = conteudo;
        this.hashAnterior = hashAnterior;
    }


    public String obterDadosParaHash() {
        return id + timeStamp + conteudo.serializarParaHash() + hashAnterior;
    }

    // Getters e Setters
    public int getId() { return id; }
    public long getTimeStamp() { return timeStamp; }
    public Conteudo getConteudo() { return conteudo; }

    // Set permitindo adulteração (para fins de teste/demonstração)
    public void setConteudo(Conteudo conteudo) { this.conteudo = conteudo; }

    public String getHashAnterior() { return hashAnterior; }
    public String getHashBloco() { return hashBloco; }
    public void setHashBloco(String hashBloco) { this.hashBloco = hashBloco; }

    @Override
    public String toString() {
        return "Bloco[" + id + "] | Prev: " + (hashAnterior.length() > 8 ? hashAnterior.substring(0,8) + "..." : hashAnterior) +
                " | Hash: " + (hashBloco.length() > 8 ? hashBloco.substring(0,8) + "..." : hashBloco) +
                " | Dado: " + conteudo.serializarParaHash();
    }
}