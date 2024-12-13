/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author Deibidson Mesquita
 */
public interface VendaInterface {

    public void salvaVenda(Venda v);

    public void cancelarVenda(Venda v);

    public void deleteVenda(Venda v);

    public List<Venda> listaVendas();

    public void adicionarItem(ItemVenda item);

    public List<ItemVenda> listaItens(Venda vd);

    public Venda getVendaByID(long id);

    public long getNumeroProximaVendaCupom();

}
