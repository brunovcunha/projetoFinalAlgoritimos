import java.util.List;

/**
 * Venda
 */
public class Venda {
    private int idVenda;
    private String cliente;
    private String dataVenda;
    private String formaPagamento;
    private String status;
    private List<Jogos> jogosVendidos;

    public Venda(int idVenda, String cliente, String dataVenda, String formaPagamento, String status,
            List<Jogos> jogosVendidos) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.jogosVendidos = jogosVendidos;
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

    public List<Jogos> getJogosVendidos() {
        return jogosVendidos;
    }

    public void setJogosVendidos(List<Jogos> jogosVendidos) {
        this.jogosVendidos = jogosVendidos;
    }

}