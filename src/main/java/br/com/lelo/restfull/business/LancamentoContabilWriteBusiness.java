package br.com.lelo.restfull.business;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lelo.restfull.domain.LancamentoContabil;
import br.com.lelo.restfull.repository.LancamentoContabilRepository;

@Service
public class LancamentoContabilWriteBusiness {

    @Autowired
    public LancamentoContabilRepository repository;

    @Autowired
    public LancamentoContabilReadBusiness readBusiness;

    @Transactional(readOnly = false)
    public UUID novoLancamento(LancamentoContabil model) {

        readBusiness.findContaByCodigo(model.getContaContabilCodigo())
                    .ifPresent(conta -> model.setContaContabil(conta));

        return repository.save(model).getId();
    }

    
}
