package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class Categoria implements Serializable {

    private static final long serialVersionUID = 544852142707290648L;

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "increment")
    private Long id;

    @Column(length = 60, unique = true)
    private String nome;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    @Cascade(CascadeType.ALL)
    private List<Produto> produtos;

    public Categoria() {
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }


}
