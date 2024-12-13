
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Deibidson Mesquita
 */

@Entity
@Getter
@Setter
public class Cargo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private static final long serialVersionUID = 4700284130933106702L;

    private String cargo;
    private String descr;

    @ManyToOne
    private Departamento departamento;

    public Cargo() {
    }

    

}
