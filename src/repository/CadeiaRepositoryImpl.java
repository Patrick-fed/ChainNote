package repository;

import interfaces.Conteudo;
import interfaces.InsertBlocoRepository;
import interfaces.ReadBlocoRepository;
import model.Bloco;
import model.Cadeia;

import java.util.List;

public class CadeiaRepositoryImpl implements InsertBlocoRepository, ReadBlocoRepository {
    private Cadeia blockchain;

    public CadeiaRepositoryImpl(Cadeia blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void insert(Bloco bloco) {
        blockchain.adicionarBloco((Conteudo) bloco);
        System.out.println("Bloco ID " + bloco.getId() + " inserido na cadeia com sucesso!");
    }

    @Override
    public List<Bloco> buscarTodos() {
        return blockchain.getCadeia();
    }

    @Override
    public Bloco buscaUltimoBloco() {
        return blockchain.getUltimoBloco();
    }

    @Override
    public Bloco buscarPorHash(String hash) {
        for(Bloco bloco: blockchain.getCadeia()){
            if(bloco.getHashBloco().equals(hash)){
                return bloco;
            }
        }
        return null;
    }
}
