package service;

import client.HubFaturamentoClient;
import model.Pedido;
import java.util.HashMap;
import java.util.Map;

public class VendaService {
    private final Map<Long, Pedido> bancoPedidos = new HashMap<>();
    private final HubFaturamentoClient hubClient;

    public VendaService(HubFaturamentoClient hubClient) {
        this.hubClient = hubClient;
    }

    public Pedido criarPedido(Long id, Double valorTotal) {
        Pedido pedido = new Pedido(id, valorTotal);
        bancoPedidos.put(id, pedido);
        return pedido;
    }

    public Pedido fecharPedido(Long pedidoId) {
        Pedido pedido = bancoPedidos.get(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
        pedido.setFechado(true);
        Long faturaId = hubClient.enviarPedidoParaFaturamento(pedido.getId());
        pedido.setFaturaId(faturaId);
        return pedido;
    }
}
