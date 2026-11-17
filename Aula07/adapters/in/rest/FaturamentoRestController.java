package adapters.in.rest;

import application.usecase.FaturarPedidoUseCase;

public class FaturamentoRestController {
    private final FaturarPedidoUseCase faturarPedidoUseCase;

    public FaturamentoRestController(FaturarPedidoUseCase faturarPedidoUseCase) {
        this.faturarPedidoUseCase = faturarPedidoUseCase;
    }

    public Long faturar(Long pedidoId) {
        return faturarPedidoUseCase.executar(pedidoId);
    }
}
