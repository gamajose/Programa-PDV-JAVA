
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Deibidson Mesquita
 */
@Embeddable
public class EnderecoEntrega implements Serializable {

    private static final long serialVersionUID = 2499660439571366127L;

    private String end;
    private int n;
    private String cidade;
    private String uf;
    private String cep;
    private String bairro;
    private String referencia;

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
