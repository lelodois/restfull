package br.com.lelo.restfull.service;

import java.util.List;
import java.util.UUID;

import br.com.lelo.restfull.message.LancamentoContabilMessage;
import br.com.lelo.restfull.message.LancamentoContabilStatusMessage;

public interface MovimentoContabilService {

    public UUID novoLancamento(LancamentoContabilMessage lancamento);

    public LancamentoContabilMessage getLancamentoById(UUID id);

    public List<LancamentoContabilMessage> getLancamentosByContaContabil(Long contaContabil);

    public LancamentoContabilStatusMessage getLancamentoStatusByContaContabil(Long contaContabil);

    public LancamentoContabilStatusMessage getLancamentoStatus();

}
