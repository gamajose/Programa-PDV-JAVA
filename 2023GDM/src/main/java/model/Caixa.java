package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Deibidson Mesquita
 */
@Entity
@Data
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String descr;

    @Column(columnDefinition = "DATE", nullable = false, unique = true)
    private LocalDate dtabertura;

    @Column(columnDefinition = "DATE")
    private LocalDate dtfechamento;

    private BigDecimal valorAbertura;
    private BigDecimal valorFecamento;
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa", fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<Lancamento> lancamentos;

    public Caixa() {
    }

    public Caixa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
