
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento implements Serializable {

    private static final long serialVersionUID = -2255209958192641594L;
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Crediario crediario;

    private BigDecimal valor;
    private LocalDate dataPgto;

    public Pagamento(BigDecimal valor, LocalDate dataPgto) {
        this.valor = valor;
        this.dataPgto = dataPgto;
    }

    public Pagamento(Crediario crediario, BigDecimal valor, LocalDate dataPgto, Cliente cliente) {
        this.crediario = crediario;
        this.valor = valor;
        this.dataPgto = dataPgto;
        this.cliente = cliente;
    }

    public Pagamento(BigDecimal valor, LocalDate dataPgto, Cliente cliente) {

        this.valor = valor;
        this.dataPgto = dataPgto;
        this.cliente = cliente;
    }

    public Pagamento() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return dataPgto;
    }

    public void setData(LocalDate data) {
        this.dataPgto = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Crediario getCrediario() {
        return crediario;
    }

    public void setCrediario(Crediario crediario) {
        this.crediario = crediario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
