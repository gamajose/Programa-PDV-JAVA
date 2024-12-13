package repositorio;

import Interfaces.PedidoInterface;
import Utilitarios.HibernateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Pedido;
import model.Produto;
import model.Vendedor;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PedidoDao implements PedidoInterface {

    @Override
    public long salvaPedido(Pedido p) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(p);
            session.getTransaction().commit();
            return p.getId();
        }
    }

    public long atualizaPedido(Pedido p) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            return p.getId();
        }
    }

    @Override
    public Pedido pedidoPorCodigo(long codigo) {

        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();                     //Select p from Pedido p JOIN FETCH p.itemPedido Where p.id = :id 

            Query<Pedido> query = session.createQuery("Select p from Pedido p "
                    + "JOIN FETCH p.itemPedido ip "
                    + "JOIN FETCH ip.produto pd "
                    + "JOIN FETCH pd.estoque "
                    + "Where p.id = :id "
            );

            query.setParameter("id", codigo);
            Pedido pedido = query.getSingleResult();//usando max
            session.getTransaction().commit();
            return pedido;
        }

    }

    @Override
    public void deletePedido(Pedido p) {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Pedido> listaPedidos() {
        List<Pedido> listagemPedidos = new ArrayList<>();
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            listagemPedidos = session.createQuery("from Pedido p", Pedido.class).getResultList();
            session.getTransaction().commit();
        }
        return listagemPedidos;
    }

    @Override
    public List<Pedido> listaPedidosVendedor(Vendedor v) {
        List<Pedido> listagemPedidos = new ArrayList<>();
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from Pedido p WHERE p.vendedor.id = :codigo", Pedido.class);
            query.setParameter("codigo", v.getId());

            listagemPedidos = query.list();
            session.getTransaction().commit();
        }
        return listagemPedidos;
    }

    @Override
    public List<Pedido> pedidosPorCliente(Cliente c) {
        List<Pedido> listagemPedidos = new ArrayList<>();
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from Pedido p WHERE p.cliente.id = :codigo", Pedido.class);
            query.setParameter("codigo", c.getId());

            listagemPedidos = query.list();
            session.getTransaction().commit();
        }
        return listagemPedidos;
    }

    @Override
    public BigDecimal calcularTotalPedido(Pedido p) {
        BigDecimal total = BigDecimal.ZERO;
//       
//        p.getProdutos().forEach(produto -> {
//            total.add(produto.getPreco());
//        });

        return total;
    }

    @Override
    public List<Produto> produtos(Pedido p) {
        List<Produto> listagemProdutosPorPedidos = new ArrayList<>();
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT pr From Pedido pe, Produto pr WHERE pe.id = :codigo", Produto.class);
            query.setParameter("codigo", p.getId());

            listagemProdutosPorPedidos = query.list();
            session.getTransaction().commit();
        }
        return listagemProdutosPorPedidos;
    }

    @Override
    public long geraNumeroProximoPedido() {
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Long proxId;
            Query query = session.createQuery("SELECT max(p.id) as maximo From Pedido p", Long.class);
            if (query.uniqueResult() == null) {
                proxId = 1L;
            } else {
                proxId = (Long) query.uniqueResult() + 1;
            }
            session.getTransaction().commit();
            return proxId;
        }

    }

    @Override
    public List<Pedido> listaPedidosPorData(LocalDate v) {
        List<Pedido> listagem = null;
        try (Session session = HibernateUtil.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT p From Pedido p WHERE p.dataPedido = :dt", Pedido.class);
            query.setParameter("dt", v);

            listagem = query.list();
            session.getTransaction().commit();
        }
        return listagem;
    }

}
