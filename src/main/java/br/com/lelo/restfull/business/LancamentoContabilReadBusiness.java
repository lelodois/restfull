package br.com.lelo.restfull.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.lelo.restfull.domain.BaseModel;
import br.com.lelo.restfull.domain.ContaContabil;
import br.com.lelo.restfull.domain.LancamentoContabil;
import br.com.lelo.restfull.exception.NotFoundItemException;
import br.com.lelo.restfull.repository.ContaContabilRepository;
import br.com.lelo.restfull.repository.LancamentoContabilRepository;

@Component
public class LancamentoContabilReadBusiness {

    @Autowired
    public LancamentoContabilRepository lancamentoRepository;

    @Autowired
    public ContaContabilRepository contaRepository;

    @Autowired
    public LancamentoContabilWriteBusiness contaContabilBusiness;

    @Transactional(readOnly = true)
    public LancamentoContabil findLancamentoById(String id) {
        Optional<LancamentoContabil> maybeLancamento = lancamentoRepository.findById(BaseModel.fromString(id));

        if (maybeLancamento.isPresent() == false) {
            throw new NotFoundItemException();
        }

        return maybeLancamento.get();
    }

    @Transactional(readOnly = true)
    public List<LancamentoContabil> findLancamentosByContaContabil(Long contaContabil) {
        Optional<ContaContabil> maybeContaContabil = this.findContaByCodigo(contaContabil);

        if (maybeContaContabil.isPresent() == false) {
            throw new NotFoundItemException();
        }
        return maybeContaContabil.get().getLancamentos();
    }

    @Transactional(readOnly = true)
    public Optional<ContaContabil> findContaByCodigo(Long codigo) {
        return contaRepository.findOne(Example.of(new ContaContabil(codigo)));
    }

    @Transactional(readOnly = true)
    public List<LancamentoContabil> findAllLancamentos() {
        return lancamentoRepository.findAll();
    }

}