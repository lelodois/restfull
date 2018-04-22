package br.com.lelo.restfull.service;

import java.util.List;

import br.com.lelo.restfull.message.LancamentoContabilMessage;
import br.com.lelo.restfull.message.LancamentoContabilStatusMessage;

public interface MovimentoContabilService {

    public String novoLancamento(LancamentoContabilMessage lancamento);

    public LancamentoContabilMessage getLancamentoById(String id);

    public List<LancamentoContabilMessage> getLancamentosByContaContabil(Long contaContabil);

    public LancamentoContabilStatusMessage getLancamentoStatusByContaContabil(Long contaContabil);

    public LancamentoContabilStatusMessage getLancamentoStatus();

}
