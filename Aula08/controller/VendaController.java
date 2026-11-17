package controller;

import model.Pedido;
import service.VendaService;

public class VendaController {
    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public String fechar(Long pedidoId) {
        try {
            Pedido pedido = vendaService.fecharPedido(pedidoId);
            return "redirect:/vendas?sucesso=true&faturaId=" + pedido.getFaturaId();
        } catch (Exception e) {
            return "redirect:/vendas?erro=" + e.getMessage();
        }
    }
}
