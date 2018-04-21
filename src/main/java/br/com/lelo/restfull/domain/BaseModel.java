package br.com.lelo.restfull.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 6116726674865950790L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "dt_cadastro", updatable = false, nullable = false)
    private Date dataCadastro;

    public final UUID getId() {
        return id;
    }

    public final void setId(UUID id) {
        this.id = id;
    }

    public final Date getDataCadastro() {
        return dataCadastro;
    }

    public final void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
