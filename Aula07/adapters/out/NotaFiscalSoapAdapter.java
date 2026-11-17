package adapters.out;

import domain.ports.out.NotaFiscalPort;

public class NotaFiscalSoapAdapter implements NotaFiscalPort {
    @Override
    public String emitirNotaFiscal(Long pedidoId) {
        String base = String.format("%010d", pedidoId);
        return "3526111234567800019955001" + base + "123456789";
    }
}
