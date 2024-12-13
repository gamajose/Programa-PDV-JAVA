/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import model.Fornecedor;

/**
 *
 * @author Deibidson Mesquita
 */
public interface FornecedoresInterface {

    public List<Fornecedor> listaFornecedores();

    public void deleteFornecedor(long id);

    public Fornecedor fornecedorByCodigo(long codigo);

    public void cadastra(Fornecedor f);

    public Fornecedor fornecedorByNome(String nome);

}
