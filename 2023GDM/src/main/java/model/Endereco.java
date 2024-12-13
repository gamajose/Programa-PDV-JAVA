package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco implements Serializable {

    private static final long serialVersionUID = 6733500123948062082L;
    @Id
    @GeneratedValue
    private Long id;

    private String endereco;
    private int numero;
    private String cidade;
    private String uf;
    private String cep;
    private String bairro;
    private String referencia;
    private String tipo;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Vendedor vendedor;

    public Endereco() {
    }

    public Endereco(Long id, String endereco, int numero, String cidade, String uf, String cep, String bairro, String referencia, String tipo) {
        this.id = id;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.bairro = bairro;
        this.referencia = referencia;
        this.tipo = tipo;
    }

    

}
