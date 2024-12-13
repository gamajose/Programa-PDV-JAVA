package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente implements Serializable {

    private static final long serialVersionUID = 7106801829663849989L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ", initialValue = 100)

    @SerializedName("id")
    @Expose
    private long id;

    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private String celular;
    private String status;
    private String apelido;
    private String sexo;
    private String estadocivil;
    private BigDecimal limiteCredito;
    private String mae;
    private String pai;
    private String companheiro;
    private String obs;
    private String datacadastro;
    private String tipo;
    private String profissao;

    private String nascimento;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    //@Fetch(FetchMode.JOIN)
    private List<Pedido> pedidoCollection;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> listaEndereco = new ArrayList<>();

    @Embedded
    private PessoaJuridica pessoaJuridica;

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    

}
