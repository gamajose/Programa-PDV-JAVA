package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Departamento implements Serializable {

    private static final long serialVersionUID = -5483344467870404832L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "departamento", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Cargo> cargos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "departamento")
    private List<Vendedor> vendedores;

    public Departamento() {
    }

    public Departamento(Long id, String nome, List<Vendedor> vendedores) {
        this.id = id;
        this.nome = nome;
        this.vendedores = vendedores;
    }

    public Departamento(String nome, List<Vendedor> vendedores) {
        this.nome = nome;
        this.vendedores = vendedores;
    }

    public Departamento(Long id) {
        this.id = id;
    }



}
