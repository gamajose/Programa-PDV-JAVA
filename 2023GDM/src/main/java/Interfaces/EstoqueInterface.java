package Interfaces;

import model.Estoque;
import model.Produto;

/**
 *
 * @author Deibidson Mesquita
 */
public interface EstoqueInterface {

    public void saveEstoque(Estoque e);

    public Produto estoqueByCodigoProduto(long codigoProduto);

    public Produto estoqueByNomeProduto(String nomeproduto);

    public void atualizarEstoque(Estoque p);

    public void delete(long e);

}
