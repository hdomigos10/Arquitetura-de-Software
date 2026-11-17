package domain.ports.out;

public interface BoletoPort {
    String emitirBoleto(Long pedidoId);
}
