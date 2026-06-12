package interfaces;

import model.Bloco;
import java.util.List;

public interface ReadBlocoRepository {
    public List<Bloco> buscarTodos();

    public Bloco buscaUltimoBloco();

    public Bloco buscarPorHash(String hash);
}
