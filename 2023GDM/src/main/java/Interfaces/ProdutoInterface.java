package Interfaces;

import java.util.List;
import model.Produto;

public interface ProdutoInterface {

    public List<Produto> listaProdutos();

    public void deleteProduto(long p);

    public Produto produtoByCodigo(long codigo);

    public Produto produtoByCodigoBarras(String codigobar);

    public void atualizarProduto(Produto p);

    public void cadastra(Produto p);

    public void alteraStatus(long codigo, String status);
}
