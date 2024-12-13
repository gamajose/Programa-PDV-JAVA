/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import model.CartaoLancamento;

/**
 *
 * @author Deibidson Mesquita
 */
public interface LancamentoCartaoInter {

    public void regitrarTrasacaoComCartao(CartaoLancamento cl);

    public List<CartaoLancamento> lancamentosCartao();

    public CartaoLancamento mostrarCartaoCreditoLancamentoDetalhe(long id);

    public void deleteLancamentoCartaoPorVendaID(long cl);

}
