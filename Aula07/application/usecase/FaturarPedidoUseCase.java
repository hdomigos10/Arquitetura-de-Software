package application.usecase;

import domain.model.Fatura;
import domain.ports.out.BoletoPort;
import domain.ports.out.EmailPort;
import domain.ports.out.FaturaRepositoryPort;
import domain.ports.out.NotaFiscalPort;

public class FaturarPedidoUseCase {
    private final FaturaRepositoryPort faturaRepository;
    private final BoletoPort boletoPort;
    private final NotaFiscalPort notaFiscalPort;
    private final EmailPort emailPort;

    public FaturarPedidoUseCase(FaturaRepositoryPort faturaRepository,
                                BoletoPort boletoPort,
                                NotaFiscalPort notaFiscalPort,
                                EmailPort emailPort) {
        this.faturaRepository = faturaRepository;
        this.boletoPort = boletoPort;
        this.notaFiscalPort = notaFiscalPort;
        this.emailPort = emailPort;
    }

    public Long executar(Long pedidoId) {
        Fatura fatura = new Fatura(pedidoId);

        fatura.setCodigoBarrasBoleto(boletoPort.emitirBoleto(pedidoId));
        fatura.setChaveAcessoNf(notaFiscalPort.emitirNotaFiscal(pedidoId));
        fatura.setHashEmail(emailPort.enviarNotificacao(pedidoId));

        Fatura salva = faturaRepository.salvar(fatura);
        return salva.getId();
    }
}
