package model;

import Utilitarios.FormaPagamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Deibidson Mesquita
 */

@Entity
@Getter
@Setter
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "gent")
    @GenericGenerator(name = "gent", strategy = "increment")
    @Column(nullable = false, unique = true)
    private Long id;

    private BigDecimal total;
    private BigDecimal desconto;

    @Column(name = "FORMA_PGTO")
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @OneToOne(optional = true)
    @Fetch(FetchMode.JOIN) //OBS ALTERADO ADD EM 25/7/19
    private Cliente cliente;

    private String reponsavel;
//    @Column(name = "USUARIOID")
    private int codigoResponsavel;

    @Column(columnDefinition = "DATE")
    private LocalDate data;
    private String hora;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itensVenda;

    private int totalItens;

    @ManyToOne(cascade = CascadeType.ALL)
    private Crediario crediario;

    public Venda() {
    }

    public Venda(Long id) {
        this.id = id;
    }

   

}
