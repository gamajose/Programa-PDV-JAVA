/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import model.ItemVenda;

/**
 *
 * @author Deibidson Mesquita
 */
public interface ItemVendaInterface {

    public ItemVenda getItemPorCodigoProduto(long codigo);

    public void delete(ItemVenda it);

}
