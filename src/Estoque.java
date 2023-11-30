import java.util.List;

public class Estoque {
    private List<Jogos> jogosEstoque;

    public Estoque(List<Jogos> jogosEstoque) {
        this.jogosEstoque = jogosEstoque;
    }

    public void adicionarJogo(Jogos jogo) {
        jogosEstoque.add(jogo);
    }

    public void removerJogo(Jogos jogo) {
        jogosEstoque.remove(jogo);
    }
}
