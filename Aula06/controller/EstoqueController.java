package controller;

import service.ProdutoService;

public class EstoqueController {
    private final ProdutoService produtoService;

    public EstoqueController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public String entrada(Long produtoId, int qtd) {
        try {
            produtoService.processarEntrada(produtoId, qtd);
            return "redirect:/estoque?sucesso=entrada";
        } catch (Exception e) {
            return "redirect:/estoque?erro=" + e.getMessage();
        }
    }

    public String saida(Long produtoId, int qtd) {
        try {
            produtoService.processarSaida(produtoId, qtd);
            return "redirect:/estoque?sucesso=saida";
        } catch (Exception e) {
            return "redirect:/estoque?erro=" + e.getMessage();
        }
    }

    public String descontinuar(Long produtoId, boolean isAdmin) {
        try {
            produtoService.descontinuarProduto(produtoId, isAdmin);
            return "redirect:/produtos?sucesso=descontinuado";
        } catch (Exception e) {
            return "redirect:/produtos?erro=" + e.getMessage();
        }
    }
}
