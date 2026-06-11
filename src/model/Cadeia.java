package model;
import java.util.List;
import java.util.ArrayList;

public class Cadeia {
    private List <Bloco> cadeia = new ArrayList<>();

    public void adicionarBloco(Bloco novoBloco) {
        cadeia.add(novoBloco);
    }

    public List<Bloco> getCadeia() {
        return cadeia;
    }

    public Bloco getUltimoBloco() {
        if (cadeia.isEmpty()) {
            return null;
        }
        return cadeia.get(cadeia.size() - 1);
    }

    public int getTamanho() {
        return cadeia.size();
    }
}
