package service;

import model.Produto;
import model.StatusProduto;
import java.util.HashMap;
import java.util.Map;

public class ProdutoService {
    private final Map<Long, Produto> bancoProdutos = new HashMap<>();

    public Produto cadastrar(Long id, String nome) {
        Produto produto = new Produto(id, nome);
        bancoProdutos.put(id, produto);
        return produto;
    }

    public void processarEntrada(Long produtoId, int qtd) {
        Produto produto = buscarPorId(produtoId);
        produto.registrarEntrada(qtd);
    }

    public void processarSaida(Long produtoId, int qtd) {
        Produto produto = buscarPorId(produtoId);
        produto.registrarSaida(qtd);
    }

    public void descontinuarProduto(Long produtoId, boolean isAdmin) {
        Produto produto = buscarPorId(produtoId);
        produto.descontinuar(isAdmin);
    }

    public Produto buscarPorId(Long id) {
        Produto produto = bancoProdutos.get(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        return produto;
    }
}
