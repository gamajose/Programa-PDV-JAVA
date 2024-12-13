package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Getter
@Setter
public class Produto implements Serializable {

    private static final long serialVersionUID = 6779474029942253133L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String descricao;
    private String marca;
    private BigDecimal preco;
    private BigDecimal precoCusto;
    private String fabricao;
    private double peso;
    private String dimensao;
    private String foto;
    private String capacidade;
    @Column(nullable = true, length = 200)
    private String obs;
    private Double comissao;

    private String codigoBarras;
    private int ncm;
    private String referencia;
    private String cor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id")
    @Fetch(FetchMode.JOIN)
    private Estoque estoque;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "categoria_id")
    @Fetch(FetchMode.JOIN)
    private Categoria categoria;

    @JoinColumn(name = "fornecedor_codigo", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(Long codigo) {
        this.codigo = codigo;
    }

   

}
