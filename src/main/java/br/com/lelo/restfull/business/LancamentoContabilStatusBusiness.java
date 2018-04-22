package br.com.lelo.restfull.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lelo.restfull.domain.LancamentoContabil;
import br.com.lelo.restfull.message.LancamentoContabilStatusMessage;

@Component
public class LancamentoContabilStatusBusiness {

    public LancamentoContabilStatusMessage getStatus(List<LancamentoContabil> lancamentos) {

        LancamentoContabilStatusMessage status = new LancamentoContabilStatusMessage();

        if (lancamentos.isEmpty()) {
            return status;
        }

        status.initByLancamento(lancamentos.get(0));

        lancamentos.forEach(item -> {
            status.setSoma(status.getSoma().add(item.getValor()));
            status.setMax(this.getMaxValue(status.getMax(), item.getValor()));
            status.setMin(this.getMinValue(status.getMin(), item.getValor()));
        });

        status.setQuantidade(new BigDecimal(lancamentos.size()));
        status.setMedia(status.getSoma().divide(status.getQuantidade(), RoundingMode.HALF_UP));
        return status;
    }

    private BigDecimal getMaxValue(BigDecimal primeiroValor, BigDecimal segundoValor) {
        if (primeiroValor.compareTo(segundoValor) == 1)
            return primeiroValor;

        return segundoValor;
    }

    private BigDecimal getMinValue(BigDecimal primeiroValor, BigDecimal segundoValor) {
        if (primeiroValor.compareTo(segundoValor) == -1)
            return primeiroValor;

        return segundoValor;
    }

}
