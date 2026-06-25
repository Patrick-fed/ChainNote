package View;


import model.Bloco;

public class BlocoExibicao {
    public static String formatarParaConsole(Bloco bloco) {
        String hashAntShort = bloco.getHashAnterior().length() > 8
                ? bloco.getHashAnterior().substring(0, 8) + "..."
                : bloco.getHashAnterior();

        String hashAtualShort = bloco.getHashBloco().length() > 8
                ? bloco.getHashBloco().substring(0, 8) + "..."
                : bloco.getHashBloco();

        return String.format("Bloco[%d] | Prev: %s | Hash: %s | Dado: %s",
                bloco.getId(),
                hashAntShort,
                hashAtualShort,
                bloco.getConteudo().serializarParaHash()
        );
    }
}
