
package Interfaces;

import java.math.BigDecimal;
import java.util.List;
import model.Caixa;
import model.CaixaDiario;

/**
 *
 * @author Deibidson Mesquita
 */
public interface CaixaInterface {

    public BigDecimal calcularSaldoDiario();

    public void deleteCaixa(Caixa cx);

    public void salvaCaixa(Caixa c);

    public List<Caixa> listaCaixa();

    public List<CaixaDiario> listaCaixaDiario();

    public Caixa getCaixaPoCodigo(Long codigo);

    public String getStatusCaixa(Caixa c);

    public Caixa getCaixaPorStatusAberto();

    public void abrirCaixa(Caixa cx);

    public void fecharCaixa(Caixa cx);

    public void salvaCaixaDiario(CaixaDiario cxd);

}
