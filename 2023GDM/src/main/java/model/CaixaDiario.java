
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class CaixaDiario implements Serializable {

    private static final long serialVersionUID = -6967087629718201100L;

    @Id
    @GeneratedValue(generator = "gent")
    @GenericGenerator(name = "gent", strategy = "increment")
    private long id;
    private String responsavel;
    @Column(columnDefinition = "DATE", nullable = false, unique = true)
    private LocalDate dataCaixa;
    @Column(nullable = false)
    private String horaFechamento;
    private BigDecimal valorSaida;
    private BigDecimal valorEntradas;
    private BigDecimal saldo;
    private BigDecimal total;

    @ManyToOne
    private Caixa caixa;

    public CaixaDiario() {
    }

  
}
