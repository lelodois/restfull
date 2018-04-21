package br.com.lelo.restfull.message;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LancamentoContabilMessage {

    @Min(value = 1)
    @NotNull
    private Long contaContabil;

    @NotEmpty
    @Min(value = 1)
    private String data;

    @NotNull
    private BigDecimal valor;
    
    public static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyymmdd");
    
    public Long getContaContabil() {
        return contaContabil;
    }

    public String getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setContaContabil(Long contaContabil) {
        this.contaContabil = contaContabil;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
