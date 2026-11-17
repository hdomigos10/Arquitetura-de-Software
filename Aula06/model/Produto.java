package model;

public class Produto {
    private Long id;
    private String nome;
    private int quantidadeEstoque;
    private StatusProduto status;

    public Produto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.quantidadeEstoque = 0;
        this.status = StatusProduto.INDISPONÍVEL;
    }

    public void registrarEntrada(int qtd) {
        if (this.status == StatusProduto.DESCONTINUADO) {
            throw new IllegalStateException("Produto descontinuado não pode ser manipulado.");
        }
        if (qtd <= 0) {
            throw new IllegalArgumentException("Quantidade de entrada deve ser maior que zero.");
        }
        this.quantidadeEstoque += qtd;
        if (this.quantidadeEstoque > 0 && this.status == StatusProduto.INDISPONÍVEL) {
            this.status = StatusProduto.DISPONÍVEL;
        }
    }

    public void registrarSaida(int qtd) {
        if (this.status == StatusProduto.DESCONTINUADO) {
            throw new IllegalStateException("Produto descontinuado não pode ser manipulado.");
        }
        if (qtd <= 0 || this.quantidadeEstoque < qtd || this.quantidadeEstoque == 0) {
            throw new IllegalStateException("Estoque insuficiente ou indisponível.");
        }
        this.quantidadeEstoque -= qtd;
        if (this.quantidadeEstoque == 0) {
            this.status = StatusProduto.INDISPONÍVEL;
        }
    }

    public void descontinuar(boolean isAdmin) {
        if (!isAdmin) {
            throw new SecurityException("Apenas o administrador pode descontinuar um produto.");
        }
        this.status = StatusProduto.DESCONTINUADO;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
