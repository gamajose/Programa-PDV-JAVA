
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Getter
@Setter
public class Crediario implements Serializable {

    private static final long serialVersionUID = -8941576544284076753L;

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "crediario", orphanRemoval = true)
    private List<Venda> vendas;

    @OneToMany(mappedBy = "crediario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<Pagamento> pagamentos;

    @ManyToOne(cascade = CascadeType.ALL)
    private Conta conta;

    public Crediario() {
    }
  
}
