package adapters.out;

import domain.ports.out.BoletoPort;
import java.util.UUID;

public class BoletoFilaAdapter implements BoletoPort {
    @Override
    public String emitirBoleto(Long pedidoId) {
        return "34191.79001 01043.510047 91020.150008 1 " + Math.abs(UUID.randomUUID().hashCode());
    }
}
