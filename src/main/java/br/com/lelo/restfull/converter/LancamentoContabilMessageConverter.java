package br.com.lelo.restfull.converter;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lelo.restfull.domain.ContaContabil;
import br.com.lelo.restfull.domain.LancamentoContabil;
import br.com.lelo.restfull.exception.InvalidDateFormatException;
import br.com.lelo.restfull.message.LancamentoContabilMessage;
import ch.lambdaj.function.convert.Converter;

@Component
public class LancamentoContabilMessageConverter implements Converter<LancamentoContabilMessage, LancamentoContabil> {

    @Override
    public LancamentoContabil convert(LancamentoContabilMessage message) {
        LancamentoContabil model = new LancamentoContabil();
        model.setContaContabil(new ContaContabil(message.getContaContabil()));
        model.setDataLancamento(this.getDateByMessageFormat(message.getData()));
        model.setValor(message.getValor());
        model.setDataCadastro(new Date());
        model.getContaContabil().setDataCadastro(new Date());

        return model;
    }

    private Date getDateByMessageFormat(String data) {
        try {
            return LancamentoContabilMessage.dataFormat.parse(data);
        } catch (ParseException e) {
            throw new InvalidDateFormatException("Data do lançamento invalida");
        }
    }
}
