package adapters.out;

import domain.model.Fatura;
import domain.ports.out.FaturaRepositoryPort;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class FaturaRepositoryMemoryAdapter implements FaturaRepositoryPort {
    private final Map<Long, Fatura> banco = new HashMap<>();
    private final AtomicLong sequencia = new AtomicLong(1);

    @Override
    public Fatura salvar(Fatura fatura) {
        if (fatura.getId() == null) {
            fatura.setId(sequencia.getAndIncrement());
        }
        banco.put(fatura.getId(), fatura);
        return fatura;
    }
}
