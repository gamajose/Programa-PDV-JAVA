
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Deibidson Mesquita
 */

@Entity
@Getter
@Setter
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private BigDecimal valor;
    private LocalDate vencimento;
    private LocalDate pagamento;
    private String tipo;

    @Column(unique = false)
    private String docNumero;

    private String boletoNumero;
    private int parcelas;
    private String cendente;
    private String banco;
    private String status;

    public Conta() {
    }

    public Conta(Long id) {
        this.id = id;
    }

   
}
