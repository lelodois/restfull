package br.com.lelo.restfull.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lelo.restfull.business.LancamentoContabilReadBusiness;
import br.com.lelo.restfull.business.LancamentoContabilStatusBusiness;
import br.com.lelo.restfull.business.LancamentoContabilWriteBusiness;
import br.com.lelo.restfull.domain.LancamentoContabil;
import br.com.lelo.restfull.message.LancamentoContabilMessage;
import br.com.lelo.restfull.message.LancamentoContabilStatusMessage;
import ch.lambdaj.Lambda;
import ch.lambdaj.function.convert.Converter;

@Service
class LancamentoContabilService implements MovimentoContabilService {

    @Autowired
    private LancamentoContabilReadBusiness lancamentoReadBusiness;

    @Autowired
    private LancamentoContabilWriteBusiness lancamentoWriteBusiness;

    @Autowired
    private LancamentoContabilStatusBusiness lancamentoStatusBusiness;

    @Autowired
    public Converter<LancamentoContabilMessage, LancamentoContabil> modelConverter;

    @Autowired
    public Converter<LancamentoContabil, LancamentoContabilMessage> messageConverter;

    @Override
    public String novoLancamento(LancamentoContabilMessage message) {
        return lancamentoWriteBusiness.novoLancamento(
                                            modelConverter.convert(message));
    }

    @Override
    public LancamentoContabilMessage getLancamentoById(String id) {
        return messageConverter.convert(
                                    lancamentoReadBusiness.findLancamentoById(id));
    }
    
    @Override
    public List<LancamentoContabilMessage> getLancamentosByContaContabil(Long contaContabil) {
        return Lambda.convert(
                        lancamentoReadBusiness.findLancamentosByContaContabil(contaContabil), 
                        messageConverter);
    }

    @Override
    public LancamentoContabilStatusMessage getLancamentoStatusByContaContabil(Long contaContabil) {
        return lancamentoStatusBusiness.getStatus(
                                            lancamentoReadBusiness.findLancamentosByContaContabil(contaContabil));
    }

    @Override
    public LancamentoContabilStatusMessage getLancamentoStatus() {
        return lancamentoStatusBusiness.getStatus(
                                            lancamentoReadBusiness.findAllLancamentos());
    }

}
