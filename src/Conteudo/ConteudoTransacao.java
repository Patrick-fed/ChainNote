package Conteudo;

import interfaces.Conteudo;

public class ConteudoTransacao implements Conteudo {
    private String remetente;
    private String destinatario;
    private double valor;

    public ConteudoTransacao(String remetente, String destinatario, double valor) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

    @Override
    public String serializarParaHash() {
        return "TX:" + remetente + "->" + destinatario + ":" + valor;
    }
}