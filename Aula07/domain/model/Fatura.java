package domain.model;

public class Fatura {
    private Long id;
    private Long pedidoId;
    private String codigoBarrasBoleto;
    private String chaveAcessoNf;
    private String hashEmail;

    public Fatura(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public String getCodigoBarrasBoleto() {
        return codigoBarrasBoleto;
    }

    public void setCodigoBarrasBoleto(String codigoBarrasBoleto) {
        this.codigoBarrasBoleto = codigoBarrasBoleto;
    }

    public String getChaveAcessoNf() {
        return chaveAcessoNf;
    }

    public void setChaveAcessoNf(String chaveAcessoNf) {
        this.chaveAcessoNf = chaveAcessoNf;
    }

    public String getHashEmail() {
        return hashEmail;
    }

    public void setHashEmail(String hashEmail) {
        this.hashEmail = hashEmail;
    }
}
