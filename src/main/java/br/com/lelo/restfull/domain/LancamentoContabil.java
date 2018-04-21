package br.com.lelo.restfull.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_contabil_lancamento")
public class LancamentoContabil extends BaseModel implements Serializable {

    private static final long serialVersionUID = -8845808173051274932L;

    @Column(name = "vl_valor")
    @NotNull
    private BigDecimal valor;

    @Column(name = "dt_lancamento")
    private Date dataLancamento;

    @NotNull
    @JoinColumn(name = "id_conta")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private ContaContabil contaContabil;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public ContaContabil getContaContabil() {
        return contaContabil;
    }

    public void setContaContabil(ContaContabil contaContabil) {
        this.contaContabil = contaContabil;
    }

    public Long getContaContabilCodigo() {
        if (getContaContabil() == null) {
            throw new IllegalArgumentException("Conta contabil not found");
        }
        return this.getContaContabil().getCodigo();
    }

}
