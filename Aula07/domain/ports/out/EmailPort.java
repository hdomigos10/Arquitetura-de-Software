package domain.ports.out;

public interface EmailPort {
    String enviarNotificacao(Long pedidoId);
}
