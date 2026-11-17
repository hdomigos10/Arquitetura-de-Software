package domain.ports.out;

import domain.model.Fatura;

public interface FaturaRepositoryPort {
    Fatura salvar(Fatura fatura);
}
