
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Deibidson Mesquita
 */
@Embeddable
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = -9090877652400438083L;
    private String razaosocial;
    private String ie;
    private String im;
    private String nomeFantasia;
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaosocial, String ie, String im, String nomeFantasia, String cnpj) {
        this.razaosocial = razaosocial;
        this.ie = ie;
        this.im = im;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
