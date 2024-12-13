
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nivelAcesso;
    private String usuario;
    private String senha;

    @OneToOne
    private Vendedor funcionario;

    private static final long serialVersionUID = 3132016283867286556L;

    public Usuario() {
    }

    public Usuario(String nivelAcesso, String usuario, String senha, Vendedor funcionario) {
        this.nivelAcesso = nivelAcesso;
        this.usuario = usuario;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public Usuario(Long id) {
        this.id = id;
    }

   

}
