package model;

public class Pedido {
    private Long id;
    private Double valorTotal;
    private boolean fechado;
    private Long faturaId;

    public Pedido(Long id, Double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.fechado = false;
    }

    public Long getId() {
        return id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public Long getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(Long faturaId) {
        this.faturaId = faturaId;
    }
}
