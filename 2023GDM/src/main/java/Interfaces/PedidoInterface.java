package Interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import model.Cliente;
import model.Pedido;
import model.Produto;
import model.Vendedor;

/**
 *
 * @author Deibidson Mesquita
 */
public interface PedidoInterface {

    public long salvaPedido(Pedido p);

    public Pedido pedidoPorCodigo(long codigo);

    public void deletePedido(Pedido p);

    public List<Pedido> listaPedidos();

    public List<Pedido> listaPedidosVendedor(Vendedor v);

    public List<Pedido> pedidosPorCliente(Cliente c);

    public BigDecimal calcularTotalPedido(Pedido p);

    public List<Produto> produtos(Pedido p);

    public long geraNumeroProximoPedido();

    public List<Pedido> listaPedidosPorData(LocalDate v);
}
