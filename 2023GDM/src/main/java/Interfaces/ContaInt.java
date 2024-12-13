/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.math.BigDecimal;
import java.util.List;
import model.Conta;

/**
 *
 * @author deibi
 */
public interface ContaInt {

    public void salva(Conta c);

    public List<Conta> listaReceber();

    public List<Conta> listaRPagar();

    public void quitaConta(Conta c);

    public void deletaConta(Long id);

    public Conta getContaById(long id);

    public BigDecimal getTotalReceber();

    public BigDecimal getTotalPagar();

}
