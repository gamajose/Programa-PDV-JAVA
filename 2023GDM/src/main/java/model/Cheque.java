
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cheque implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String numero;
    private String banco;
    private String clienteNome;
    private BigDecimal valor;
    private LocalDate dataTroca;

    private static final long serialVersionUID = -2483255779334426843L;

    public Cheque() {
    }

    public Long getId() {
        return id;
    }

    public Cheque(Long id) {
        this.id = id;
    }

    public Cheque(String numero, String banco, String clienteNome, BigDecimal valor, LocalDate dataTroca) {
        this.numero = numero;
        this.banco = banco;
        this.clienteNome = clienteNome;
        this.valor = valor;
        this.dataTroca = dataTroca;
    }

    

}
