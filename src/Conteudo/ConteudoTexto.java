package Conteudo;

import interfaces.Conteudo;

public class ConteudoTexto implements Conteudo {
    private String texto;

    public ConteudoTexto(String texto) {
        this.texto = texto != null ? texto : ""; // Garante LSP (sem nulls)
    }

    @Override
    public String serializarParaHash() {
        return "TEXTO:" + texto;
    }
}