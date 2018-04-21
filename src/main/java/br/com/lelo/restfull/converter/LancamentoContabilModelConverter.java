package br.com.lelo.restfull.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lelo.restfull.domain.LancamentoContabil;
import br.com.lelo.restfull.message.LancamentoContabilMessage;
import ch.lambdaj.function.convert.Converter;

@Component
public class LancamentoContabilModelConverter implements Converter<LancamentoContabil, LancamentoContabilMessage> {

    @Override
    public LancamentoContabilMessage convert(LancamentoContabil model) {
        LancamentoContabilMessage message = new LancamentoContabilMessage();
        message.setContaContabil(model.getContaContabilCodigo());
        message.setValor(model.getValor());
        message.setData(this.getDateByMessageFormat(model.getDataLancamento()));
        return message;
    }

    private String getDateByMessageFormat(Date date) {
        return LancamentoContabilMessage.dataFormat.format(date);
    }
}
