package br.com.lelo.restfull.message;

import java.math.BigDecimal;

public class LancamentoContabilStatusMessage {

    private BigDecimal soma = BigDecimal.ZERO;
    private BigDecimal min = BigDecimal.ZERO;
    private BigDecimal max = BigDecimal.ZERO;
    private BigDecimal media = BigDecimal.ZERO;
    private BigDecimal quantidade = BigDecimal.ZERO;

    public BigDecimal getMax() {
        return max;
    }

    public BigDecimal getMedia() {
        return media;
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSoma() {
        return soma;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setSoma(BigDecimal soma) {
        this.soma = soma;
    }

}
