package model;

import interfaces.CalculadoraHash;
import interfaces.Conteudo;
import java.util.ArrayList;
import java.util.List;

public class Cadeia {
    private List<Bloco> cadeia = new ArrayList<>();
    private CalculadoraHash calculadoraHash;


    public Cadeia(CalculadoraHash calculadoraHash) {
        this.calculadoraHash = calculadoraHash;
    }

    public void adicionarBloco(Conteudo conteudo) {
        int id = cadeia.size();
        long ts = System.currentTimeMillis();
        String hashAnterior = id == 0 ? "0" : getUltimoBloco().getHashBloco();

        Bloco novoBloco = new Bloco(id, ts, conteudo, hashAnterior);

        // Calcula o hash no momento da inserção
        String hash = calculadoraHash.calcular(novoBloco.obterDadosParaHash());
        novoBloco.setHashBloco(hash);

        cadeia.add(novoBloco);
    }

    public List<Bloco> getCadeia() {
        return cadeia;
    }

    public void setCadeia(List<Bloco> cadeia) {
        this.cadeia = cadeia;
    }

    public List<Bloco> getBlocos() { return cadeia; }

    public Bloco getUltimoBloco() {
        return cadeia.isEmpty() ? null : cadeia.get(cadeia.size() - 1);
    }
}