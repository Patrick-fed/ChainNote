package Repository;

import interfaces.InsertBlocoRepository;
import model.Bloco;
import model.Cadeia;

public class CadeiaRepositoryImpl implements InsertBlocoRepository {
    private Cadeia blockchain;

    public CadeiaRepositoryImpl(Cadeia blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void insert(Bloco bloco) {
        // O repositório agora apenas salva o objeto pronto
        blockchain.adicionarBloco(bloco);
        System.out.println("Bloco ID " + bloco.getId() + " inserido na cadeia com sucesso!");
    }
}
