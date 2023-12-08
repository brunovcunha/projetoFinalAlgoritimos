import java.util.ArrayList;

/**
 * Venda
 */
public class Venda {
    private int idVenda;
    private String cliente;
    private String dataVenda;
    private String formaPagamento;
    private String status;
    private int unidadesVendidas;
    private double valorTotal;
    private ArrayList<Jogos> jogos = new ArrayList<>();

    public Venda() {
    }

    public Venda(int idVenda, String cliente, String dataVenda, String formaPagamento, String status) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal() {
        double valorTotal = 0;
        for (Jogos jogo : jogos) {
            valorTotal += jogo.getPreco() * jogo.getQuantidade();
        }
        this.valorTotal = valorTotal;
    }

    public ArrayList<Jogos> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogos> jogos) {
        this.jogos = jogos;
    }

}