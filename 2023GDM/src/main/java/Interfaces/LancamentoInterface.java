/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import model.Lancamento;

/**
 *
 * @author Deibidson Mesquita
 */
public interface LancamentoInterface {

    public BigDecimal totalEntradas();

    public void salva(Lancamento l);

    public BigDecimal totalSaidas();

    public BigDecimal totalEntradasPorData(LocalDate l);

    public BigDecimal totalSaidasPorData(LocalDate l);

    public BigDecimal total();

    public List<Lancamento> listaLancamentos();

    public void deletaLancamento(long id);

    public Lancamento getLancamento(long id);

    public BigDecimal saldoAnterior(LocalDate date);

    public List<Lancamento> listaLancamentosByDate(LocalDate localDate);

    public void deletaLancamentoVendaCancelada(String vendaDesc, BigDecimal valor);
}
