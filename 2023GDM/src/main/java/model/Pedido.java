package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class Pedido implements Serializable {

    private static final long serialVersionUID = 8426333489931208381L;
    @Id
    @GeneratedValue(generator = "gent")
    @GenericGenerator(name = "gent", strategy = "increment")
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate dataPedido;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")

    private Cliente cliente;

    private BigDecimal total;
    private BigDecimal desconto;
    private BigDecimal frete;
    private String formaPagto;
    private String tipoPedido;
    private String obs;
    private String status;
    private String previsaoEntrega;

    @Embedded
    private EnderecoEntrega enderecoEntrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<ItemPedido> itemPedido = new ArrayList<>();

    public Pedido() {
    }

   
}
