package com.simceel.simceelback.dominio.medicao;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medicao")
public class Medicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicao_id_seq")
    @SequenceGenerator(name = "medicao_id_seq", sequenceName = "medicao_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "kwhtotal")
    private String pot_medida;

    @NotNull
    @Column(name = "pot_consumida")
    private String descricao;

    @NotNull
    @Column(name = "custo")
    private Float custo;


    // GET & SET
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPot_Medida() {
        return pot_medida;
    }

    public void setPot_Medida(String pot_medida) {
        this.pot_medida = pot_medida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }
}