package br.com.lelo.restfull.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_contabil_conta")
public class ContaContabil extends BaseModel implements Serializable {

    private static final long serialVersionUID = -1330643333486445564L;

    @Column(name = "cd_conta")
    @NotNull
    @Min(value = 1)
    private Long codigo;

    @OneToMany(mappedBy = "contaContabil", fetch = FetchType.LAZY)
    private List<LancamentoContabil> lancamentos;

    public ContaContabil() {
    }

    public ContaContabil(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<LancamentoContabil> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<LancamentoContabil> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
