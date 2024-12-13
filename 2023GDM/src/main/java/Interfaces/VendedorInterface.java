/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import java.util.Optional;
import model.Vendedor;

/**
 *
 * @author Deibidson Mesquita
 */
public interface VendedorInterface {

    public void salvaVendedor(Vendedor v);

    public void deleteVendedor(Vendedor v);

    public List<Vendedor> listaVendedores();

    public Optional<Vendedor> vendedorByCodigo(long codigo);
}
