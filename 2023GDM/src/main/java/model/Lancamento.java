
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Deibidson Mesquita
 */
@Entity
@Getter
@Setter
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    @Column(columnDefinition = "DATE")
    private LocalDate data;
    @Column(columnDefinition = "TIME")
    private LocalDateTime hora;
    private String descr;
    private BigDecimal valor;
    private BigDecimal saldoParcial;
    private String responsavel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Caixa caixa;

    public Lancamento() {
    }



}
