
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Deibidson Mesquita
 */

@Entity
@Getter
@Setter
public class CartaoLancamento implements Serializable {

    private static final long serialVersionUID = -2032301886362118381L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ", initialValue = 100)
    private long id;
    private BigDecimal valor;
    private int parcelas;
    private String bandeira;
    private LocalDate date;
    private String tipoOP;

    @OneToOne
    private Venda venda;

    public CartaoLancamento() {
    }



}
