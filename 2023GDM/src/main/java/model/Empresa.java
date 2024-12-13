package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Getter
@Setter
public class Empresa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Endereco> enderecos = new ArrayList<>();

    private String fotoLogo;
  

    @Embedded
    private PessoaJuridica pessoaJuridica;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Contato contato;

    private static final long serialVersionUID = 9037743016875265137L;

    public Empresa(Long id) {
        this.id = id;
    }

    public Empresa() {
    }

    
    

}
