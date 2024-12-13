package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estoque implements Serializable {

    private static final long serialVersionUID = 7168116165639913913L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int minimo;

    @Column(columnDefinition = "DATE")
    private LocalDate validade;

    private String status;
    private int qtdeDisponivel;
    private String localizaco;
    private String unidade;

    @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, orphanRemoval = true)
    // @Fetch(FetchMode.JOIN)
    private List<Produto> produtos = new ArrayList<>();

    

}
