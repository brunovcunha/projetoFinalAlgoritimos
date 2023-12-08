public class Jogos {
// Declaração de atributos
    private String nomeJogo;
    private String genero;
    private String plataforma;
    private String classificacao;
    private String desenvolvedora;
    private double preco;
    private int quantidade;

  public Jogos(){
    
  }

  public Jogos(String nomeJogo, String genero, String plataforma, String classificacao, String desenvolvedora, double preco, int quantidade) {
      this.nomeJogo = nomeJogo;
      this.genero = genero;
      this.plataforma = plataforma;
      this.classificacao = classificacao;
      this.desenvolvedora = desenvolvedora;
      this.preco = preco;
      this.quantidade = quantidade;
  }


// Getters e setters
    public String getNomeJogo() {
        return nomeJogo;
    }
    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    public String getDesenvolvedora() {
        return desenvolvedora;
    }
    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
