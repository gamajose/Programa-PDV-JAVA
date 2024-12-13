package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = -656282145396884243L;

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "increment")
    private Long codigo;

    @Basic
    private String tipo;

    @Basic
    private String email;

    @Basic
    private String telefone;

    private String fone2;

    private String cpf;

    @OneToMany(mappedBy = "fornecedor", orphanRemoval = true)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "fornecedor", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();

    @Embedded
    private PessoaJuridica pessoaJuridica;

    public Fornecedor() {
    }

    public Fornecedor(Long codigo) {
        this.codigo = codigo;
    }

    public Fornecedor(Long codigo, String email, String telefone, List<Produto> produtos, PessoaJuridica pessoaJuridica) {
        this.codigo = codigo;
        this.email = email;
        this.telefone = telefone;
        this.produtos = produtos;
        this.pessoaJuridica = pessoaJuridica;
    }

   

}
