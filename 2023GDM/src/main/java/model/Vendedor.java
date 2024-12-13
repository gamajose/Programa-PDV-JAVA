package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

//@Indexed
@Entity
@Getter
@Setter
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 7403722808805861487L;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "departamento_id", insertable = true, updatable = true)
    @Fetch(FetchMode.SELECT)
    private Departamento departamento;

    @Id
    @GeneratedValue(generator = "gent")
    @GenericGenerator(name = "gent", strategy = "increment")
    private Long id;

//    @Field
    private String nome;
    private String status;
    private LocalDate nascimento;
    private String sexo;
    private String estadoCivil;
    private String cnh;
    private String categoria;
    @Lob
    @Column(name = "foto", columnDefinition = "blob")
    private byte[] foto;
    private double comissao;
    private BigDecimal meta;
    private BigDecimal salario;
    private String ctps;
    private String ctpsSerie;
    private String pis;
    private String cargo;
    private LocalDate admissao;
    private String jornadaInicio;
    private String jornadaFim;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)//obs cascade
    private List<Endereco> enderecos;

    private String cpf;
    private String rg;
    private String dataexpedicao;
    private String orgaoExpedidor;
    private String email;
    private String telefone;
    private String celular;
    private String obs;

    @OneToMany(mappedBy = "vendedor", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    @Embedded
    private DadosBancarios dadosBancarios;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Usuario usuario;

    public Vendedor() {
    }

    public Vendedor(Long id) {
        this.id = id;
    }

    

}
