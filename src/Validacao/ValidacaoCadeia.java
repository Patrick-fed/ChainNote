package Validacao;

import interfaces.CalculadoraHash;
import model.Bloco;
import model.Cadeia;
import java.util.List;

public class ValidacaoCadeia {
    private CalculadoraHash calculadoraHash;

    public ValidacaoCadeia(CalculadoraHash calculadoraHash) {
        this.calculadoraHash = calculadoraHash;
    }

    public boolean isValida(Cadeia cadeia) {
        List<Bloco> blocos = cadeia.getBlocos();

        for (int i = 1; i < blocos.size(); i++) {
            Bloco blocoAtual = blocos.get(i);
            Bloco blocoAnterior = blocos.get(i - 1);

            if (!blocoAtual.getHashAnterior().equals(blocoAnterior.getHashBloco())) {
                System.out.println("Erro de link no bloco " + blocoAtual.getId());
                return false;
            }


            String hashRecalculado = calculadoraHash.calcular(blocoAtual.obterDadosParaHash());
            if (!blocoAtual.getHashBloco().equals(hashRecalculado)) {
                System.out.println("Conteudo adulterado detectado no bloco " + blocoAtual.getId());
                return false;
            }
        }
        return true;
    }
}